package br.ufrn.imd.moviessitebackend.service;

import br.ufrn.imd.moviessitebackend.model.DTO.MovieDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MoviesService {

    public ArrayList<MovieDTO> getAllMovies(){
        //create example movies
        ArrayList<MovieDTO> movies = new ArrayList<>();
        movies.add(new MovieDTO("The Shawshank Redemption", "Drama", "1994", "HBO"));
        movies.add(new MovieDTO("The Godfather", "Drama", "1972", "HBO"));
        movies.add(new MovieDTO("The Godfather: Part II", "Drama", "1974", "HBO"));
        movies.add(new MovieDTO("The Dark Knight", "Action", "2008", "HBO"));
        return movies;
    }

}
