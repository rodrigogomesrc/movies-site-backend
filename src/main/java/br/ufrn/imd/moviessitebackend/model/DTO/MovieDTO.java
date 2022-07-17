package br.ufrn.imd.moviessitebackend.model.DTO;

import java.util.UUID;

public class MovieDTO {

    private String id;
    private String title;
    private String genre;
    private String exibitionDate;
    private String channel;

    public MovieDTO(String title, String genre, String exibitionDate, String channel) {
        this.title = title;
        this.genre = genre;
        this.exibitionDate = exibitionDate;
        this.channel = channel;
        this.id = UUID.randomUUID().toString();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getExibitionDate() {
        return exibitionDate;
    }

    public void setExibitionDate(String exibitionDate) {
        this.exibitionDate = exibitionDate;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
