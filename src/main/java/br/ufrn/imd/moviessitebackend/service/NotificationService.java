package br.ufrn.imd.moviessitebackend.service;

import br.ufrn.imd.moviessitebackend.model.DTO.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class NotificationService {

    @Autowired
    private SubscriptionService subscriptionService;

    HashMap<String, SseEmitter> subscriptions = new HashMap<>();

    HashMap<String, ArrayList<MovieDTO>> notificationsByUser = new HashMap<>();

    private void addNotification(MovieDTO movie, String user) {
        if (notificationsByUser.containsKey(user)) {
            notificationsByUser.get(user).add(movie);
            System.out.println(notificationsByUser.get(user).get(0).getTitle());
        } else {
            ArrayList<MovieDTO> movies = new ArrayList<MovieDTO>();
            movies.add(movie);
            notificationsByUser.put(user, movies);
        }

    }

    public void removeNotification(String id, String user) {
        MovieDTO notificadedMovie = getNotification(user, id);
        if(notificadedMovie != null) {
            if (notificationsByUser.containsKey(user)) {
                notificationsByUser.get(user).remove(notificadedMovie);
            }
        }
    }

    public MovieDTO getNotification(String user, String id){
        for (MovieDTO movie : notificationsByUser.get(user)) {
            if (movie.getId().equals(id)) {
                return movie;
            }
        }
        return null;
    }

    public ArrayList<MovieDTO> getNotifications(String user) {
           if (notificationsByUser.containsKey(user)) {
                return notificationsByUser.get(user);
            } else {
                return new ArrayList<MovieDTO>();
            }
    }

    public void receiveNotification(MovieDTO movie) {
        String movieGenre = movie.getGenre();
        ArrayList<String> usersSubscribedToGenre = subscriptionService.getSubscriptionsByGenre(movieGenre);
        for (String subscribed: usersSubscribedToGenre) {
            addNotification(movie, subscribed);
            sendNotifications(subscribed);
        }
    }

    public SseEmitter createEmitter (String user) {
        SseEmitter emitter = new SseEmitter(0L);
        subscriptions.put(user, emitter);
        emitter.onCompletion(() -> subscriptions.remove(user));
        emitter.onTimeout(() -> subscriptions.remove(user));
        emitter.onError((throwable) -> subscriptions.remove(user));
        return emitter;
    }

    public void sendNotifications(String user) {
        if (notificationsByUser.containsKey(user)) {
            for (MovieDTO movie : notificationsByUser.get(user)) {
                try {
                    subscriptions.get(user).send(movie);
                } catch (IOException e) {
                    subscriptions.remove(user);
                }
            }
            notificationsByUser.get(user).clear();
        }
    }
}
