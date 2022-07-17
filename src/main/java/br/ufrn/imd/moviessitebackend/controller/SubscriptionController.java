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

    @PostMapping("/subscribe/{genre}")
    public ResponseEntity<String> addSubscription(@PathVariable("genre") String genre) {
        subscriptionService.addSubscription(genre);
        return ResponseEntity.ok("Subscription added");
    }

    @GetMapping("/unsubscribe/{genre}")
    public ResponseEntity<String> removeSubscription(@PathVariable("genre") String genre) {
        subscriptionService.removeSubscription(genre);
        return ResponseEntity.ok("Subscription removed");
    }

    @GetMapping("/subscriptions")
    public ArrayList<String> getSubscriptions() {
        return subscriptionService.getSubscriptions();
    }

}
