package br.ufrn.imd.moviessitebackend.controller;

import br.ufrn.imd.moviessitebackend.model.DTO.MovieDTO;
import br.ufrn.imd.moviessitebackend.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class MoviesController {

    @Autowired
    private MoviesService moviesService;

    @GetMapping("/movies")
    public ArrayList<MovieDTO> getAllMovies() {
        return moviesService.getAllMovies();
    }
}
