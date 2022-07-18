package br.ufrn.imd.moviessitebackend.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class SubscriptionService {

    HashMap<String, ArrayList<String>> subscriptionsByGenre = new HashMap<>();

    public void addSubscription(String genre, String user) {

        if (subscriptionsByGenre.containsKey(genre)) {
            subscriptionsByGenre.get(genre).add(user);
        } else {
            ArrayList<String> users = new ArrayList<String>();
            users.add(user);
            subscriptionsByGenre.put(genre, users);
        }

    }

    public void removeSubscription(String genre, String user) {
        if (subscriptionsByGenre.containsKey(genre)) {
            subscriptionsByGenre.get(genre).remove(user);
        }
    }

    public ArrayList<String> getSubscriptions(String user) {
        ArrayList<String> subscriptions = new ArrayList<>();
        for (String genre : subscriptionsByGenre.keySet()) {
            if (subscriptionsByGenre.get(genre).contains(user)) {
                subscriptions.add(genre);
            }
        }
        return subscriptions;
    }

    public ArrayList<String> getSubscriptionsByGenre(String genre) {
        return subscriptionsByGenre.containsKey(genre) ? subscriptionsByGenre.get(genre) : new ArrayList<>();
    }

}
