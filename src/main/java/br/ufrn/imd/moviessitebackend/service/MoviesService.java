package br.ufrn.imd.moviessitebackend.service;

import br.ufrn.imd.moviessitebackend.MoviesSiteBackendApplication;
import br.ufrn.imd.moviessitebackend.model.DTO.MovieDTO;
import br.ufrn.imd.moviessitebackend.util.HttpRequests;
import br.ufrn.imd.moviessitebackend.util.PersistenceBackRequests;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

@Service
public class MoviesService {

    List<MovieDTO> movies = new ArrayList<>();

    public MoviesService() {
        String response = PersistenceBackRequests.getString("/getMovies");
        Gson gson = new Gson();
        MovieDTO[] localMovies = gson.fromJson(response, MovieDTO[].class);
        for (MovieDTO movie : localMovies)
        {
            movies.add(movie);
        }
    }

    public List<MovieDTO> getAllMovies(){
        return movies;
    }

//    //while there's no integration, remove later
//    public void addMovie(MovieDTO movie){
//        movies.add(movie);
//    }

}
