package br.ufrn.imd.moviessitebackend.model.orion;

import java.util.ArrayList;

public class OrionNotification {

    private ArrayList<ContextResponse> contextResponses;
    private String subscriptionId;
    private String originator;

    public OrionNotification(ArrayList<ContextResponse> contextResponses, String subscriptionId, String originator) {
        this.contextResponses = contextResponses;
        this.subscriptionId = subscriptionId;
        this.originator = originator;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getOriginator() {
        return originator;
    }

    public void setOriginator(String originator) {
        this.originator = originator;
    }

    public ArrayList<ContextResponse> getContextResponses() {
        return contextResponses;
    }

    public void setContextResponses(ArrayList<ContextResponse> contextResponses) {
        this.contextResponses = contextResponses;
    }
}
