package br.ufrn.imd.moviessitebackend.model.DTO;

public class MovieDTO {
    private String title;
    private String genre;
    private String exibitionDate;
    private String channel;

    public MovieDTO(String title, String genre, String exibitionDate, String channel) {
        this.title = title;
        this.genre = genre;
        this.exibitionDate = exibitionDate;
        this.channel = channel;
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
}
