package br.ufrn.imd.moviessitebackend.service;

import br.ufrn.imd.moviessitebackend.model.DTO.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class NotificationService {

    @Autowired
    private SubscriptionService subscriptionService;

    HashMap<String, ArrayList<MovieDTO>> notificationsByUser = new HashMap<>();

    private void addNotification(MovieDTO movie, String user) {
        if (notificationsByUser.containsKey(user)) {
            notificationsByUser.get(user).add(movie);
        } else {
            ArrayList<MovieDTO> movies = new ArrayList<MovieDTO>();
            movies.add(movie);
            notificationsByUser.put(user, movies);
        }

    }

    public void removeNotification(String id, String user) {
        if (notificationsByUser.containsKey(user)) {
            notificationsByUser.get(user).remove(id);
        }
    }

    public ArrayList<MovieDTO> getNotifications(String user) {
           if (notificationsByUser.containsKey(user)) {
                return notificationsByUser.get(user);
            } else {
                return new ArrayList<MovieDTO>();
            }
    }

    public void receiveNotification(MovieDTO movie) {
        //check the genre of the movie from notification and add to the user based on their genre subscription
        String movieGenre = movie.getGenre();
        ArrayList<String> userSubscribedToGenre = subscriptionService.getSubscriptionsByGenre(movieGenre);
        for (String subscribed: userSubscribedToGenre) {
            addNotification(movie, subscribed);
        }

    }
}
