package br.ufrn.imd.moviessitebackend.controller;

import br.ufrn.imd.moviessitebackend.model.DTO.MovieDTO;
import br.ufrn.imd.moviessitebackend.model.orion.OrionNotification;
import br.ufrn.imd.moviessitebackend.service.NotificationService;
import com.fasterxml.jackson.core.JsonFactory;
import com.google.gson.Gson;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/notifications/{user}")
    public ArrayList<MovieDTO> getNotifications(@PathVariable("user") String user) {
        return notificationService.getNotifications(user);
    }

    @DeleteMapping("/notification/{id}/{user}")
    public ResponseEntity<String> removeNotification(@PathVariable("id") String id, @PathVariable("user") String user) {
        notificationService.removeNotification(id, user);
        return ResponseEntity.ok("Notification removed");
    }

    @PostMapping("/notify")
    public ResponseEntity<String> addNotification(@RequestHeader @RequestBody @RequestAttribute String orionNotification) {
        Gson gson = new Gson();
        OrionNotification orionNotificationObject = gson.fromJson(orionNotification, OrionNotification.class);
        String movieId = orionNotificationObject.getContextResponses().get(0).getContextElement().getId();
        String movieExibitionDate = orionNotificationObject.getContextResponses().get(0).getContextElement().getAttributes().get(2).getValue();
        String movieGenre = orionNotificationObject.getContextResponses().get(0).getContextElement().getAttributes().get(1).getValue();
        String movieTitle = orionNotificationObject.getContextResponses().get(0).getContextElement().getAttributes().get(0).getValue();
        String movieChannel = orionNotificationObject.getContextResponses().get(0).getContextElement().getAttributes().get(3).getValue();

        MovieDTO movie = new MovieDTO(movieTitle, movieGenre, movieExibitionDate, movieChannel);
        notificationService.receiveNotification(movie);
        return ResponseEntity.ok("Notification received");
    }
}
