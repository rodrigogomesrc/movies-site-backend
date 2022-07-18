package br.ufrn.imd.moviessitebackend.model.orion;

import java.util.ArrayList;

public class ContextElement {
    ArrayList<Attributes> attributes;
    String id;
    String type;
    String isPattern;

    public ContextElement(String id, String type, String isPattern) {
        this.id = id;
        this.type = type;
        this.isPattern = isPattern;
        attributes = new ArrayList<Attributes>();
    }

    public ArrayList<Attributes> getAttributes() {
        return attributes;
    }

    public void setAttributes(ArrayList<Attributes> attributes) {
        this.attributes = attributes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsPattern() {
        return isPattern;
    }

    public void setIsPattern(String isPattern) {
        this.isPattern = isPattern;
    }
}
