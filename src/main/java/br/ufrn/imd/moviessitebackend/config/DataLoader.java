package br.ufrn.imd.moviessitebackend.config;

import br.ufrn.imd.moviessitebackend.model.DTO.MovieDTO;
import br.ufrn.imd.moviessitebackend.service.MoviesService;
import br.ufrn.imd.moviessitebackend.service.NotificationService;
import br.ufrn.imd.moviessitebackend.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class DataLoader {

    @Autowired
    private SubscriptionService subscriptionService;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private MoviesService moviesService;

    @EventListener(ApplicationReadyEvent.class)
    public void createData(){
        //create fake data
        subscriptionService.addSubscription("Drama");

        moviesService.addMovie(new MovieDTO("The Shawshank Redemption", "Drama", "1994", "HBO"));
        moviesService.addMovie(new MovieDTO("The Godfather", "Drama", "1972", "HBO"));
        moviesService.addMovie(new MovieDTO("The Godfather: Part II", "Drama", "1974", "HBO"));
        moviesService.addMovie(new MovieDTO("The Dark Knight", "Action", "2008", "HBO"));

        notificationService.addNotification(new MovieDTO("The Shawshank Redemption", "Drama", "1994", "HBO"));
        notificationService.addNotification(new MovieDTO("The Godfather", "Drama", "1972", "HBO"));
        notificationService.addNotification(new MovieDTO("The Godfather: Part II", "Drama", "1974", "HBO"));
        notificationService.addNotification(new MovieDTO("The Shawshank Redemption", "Drama", "1994", "HBO"));
        notificationService.addNotification(new MovieDTO("The Godfather", "Drama", "1972", "HBO"));
        notificationService.addNotification(new MovieDTO("The Godfather: Part II", "Drama", "1974", "HBO"));

    }
}
