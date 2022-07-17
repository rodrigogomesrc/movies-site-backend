package br.ufrn.imd.moviessitebackend.controller;

import br.ufrn.imd.moviessitebackend.model.DTO.MovieDTO;
import br.ufrn.imd.moviessitebackend.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

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
    public ResponseEntity<String> addNotification(@RequestHeader @RequestBody @RequestAttribute Object orionNotification) {
        //print all information from the object
        System.out.println("will show the content of the notification");
        System.out.println(orionNotification);
        System.out.println(orionNotification.getClass());
        System.out.println(Arrays.toString(orionNotification.getClass().getDeclaredFields()));
        System.out.println(Arrays.toString(orionNotification.getClass().getDeclaredMethods()));
        System.out.println(Arrays.toString(orionNotification.getClass().getDeclaredConstructors()));
        System.out.println(Arrays.toString(orionNotification.getClass().getDeclaredClasses()));
        System.out.println(Arrays.toString(orionNotification.getClass().getDeclaredAnnotations()));
        System.out.println("end of informations");

        return ResponseEntity.ok("Notification received");
    }
}
