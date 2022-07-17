package br.ufrn.imd.moviessitebackend.service;

import br.ufrn.imd.moviessitebackend.model.DTO.MovieDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MoviesService {

    ArrayList<MovieDTO> movies = new ArrayList<MovieDTO>();

    public ArrayList<MovieDTO> getAllMovies(){
        return movies;
    }

    //while there's no integration, remove later
    public void addMovie(MovieDTO movie){
        movies.add(movie);
    }

}
