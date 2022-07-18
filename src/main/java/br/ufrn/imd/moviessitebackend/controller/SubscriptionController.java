package br.ufrn.imd.moviessitebackend.controller;

import br.ufrn.imd.moviessitebackend.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    @PostMapping("/subscribe/{genre}/{user}")
    public ResponseEntity<String> addSubscription(@PathVariable("genre") String genre, @PathVariable("user") String user) {
        subscriptionService.addSubscription(genre, user);
        return ResponseEntity.ok("Subscription added");
    }

    @GetMapping("/unsubscribe/{genre}/{user}")
    public ResponseEntity<String> removeSubscription(@PathVariable("genre") String genre, @PathVariable("user") String user) {
        subscriptionService.removeSubscription(genre, user);
        return ResponseEntity.ok("Subscription removed");
    }

    @GetMapping("/subscriptions/{user}")
    public ArrayList<String> getSubscriptions(@PathVariable("user") String user) {
        return subscriptionService.getSubscriptions(user);
    }

}
