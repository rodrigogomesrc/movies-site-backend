package br.ufrn.imd.moviessitebackend.controller;

import br.ufrn.imd.moviessitebackend.model.DTO.MovieDTO;
import br.ufrn.imd.moviessitebackend.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/notifications")
    public ArrayList<MovieDTO> getNotifications() {
        return notificationService.getNotifications();
    }

    @DeleteMapping("/notification/{id}")
    public ResponseEntity<String> removeNotification(@PathVariable("id") String id) {
        notificationService.removeNotification(id);
        return ResponseEntity.ok("Notification removed");
    }

    @PostMapping("/notify")
    public ResponseEntity<String> addNotification(MovieDTO movie) {
        notificationService.addNotification(movie);
        return ResponseEntity.ok("Notification received");
    }
}
