package br.ufrn.imd.moviessitebackend.service;

import br.ufrn.imd.moviessitebackend.model.DTO.MovieDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class NotificationService {

    ArrayList<MovieDTO> notifications = new ArrayList<MovieDTO>();
    HashMap<String, ArrayList<MovieDTO>> notificationsByUser = new HashMap<String, ArrayList<MovieDTO>>();

    public void addNotification(MovieDTO movie, String user) {
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
}
