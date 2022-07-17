package br.ufrn.imd.moviessitebackend.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SubscriptionService {

    ArrayList<String> subscriptions = new ArrayList<String>();

    public void addSubscription(String genre) {
        subscriptions.add(genre);
    }

    public void removeSubscription(String genre) {
        subscriptions.remove(genre);
    }

    public ArrayList<String> getSubscriptions() {
        return subscriptions;
    }


}
