package br.ufrn.imd.moviessitebackend.service;

import br.ufrn.imd.moviessitebackend.model.DTO.MovieDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class NotificationService {

    ArrayList<MovieDTO> notifications = new ArrayList<MovieDTO>();

    public void addNotification(MovieDTO movie) {
        notifications.add(movie);
    }

    public void removeNotification(String id) {
        for (MovieDTO movie : notifications) {
            if (movie.getId().equals(id)) {
                notifications.remove(movie);
                break;
            }
        }
    }

    public ArrayList<MovieDTO> getNotifications() {
        return notifications;
    }
}
