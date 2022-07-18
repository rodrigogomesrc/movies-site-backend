package br.ufrn.imd.moviessitebackend.service;

import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class SubscriptionService {


    HashMap<String, ArrayList<String>> subscriptionsByUser = new HashMap<String, ArrayList<String>>();

    public void addSubscription(String genre, String user) {
        if (subscriptionsByUser.containsKey(genre)) {
            subscriptionsByUser.get(genre).add(user);
        } else {
            ArrayList<String> users = new ArrayList<String>();
            users.add(user);
            subscriptionsByUser.put(genre, users);
        }

    }

    public void removeSubscription(String genre, String user) {
        if (subscriptionsByUser.containsKey(genre)) {
            subscriptionsByUser.get(genre).remove(user);
        }
    }

    public ArrayList<String> getSubscriptions(String user) {
        ArrayList<String> subscriptions = new ArrayList<String>();
        for (String genre : subscriptionsByUser.keySet()) {
            if (subscriptionsByUser.get(genre).contains(user)) {
                subscriptions.add(genre);
            }
        }
        return subscriptions;
    }

}
