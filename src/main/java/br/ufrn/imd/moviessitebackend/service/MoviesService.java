package br.ufrn.imd.moviessitebackend.service;

import br.ufrn.imd.moviessitebackend.model.DTO.MovieDTO;
import br.ufrn.imd.moviessitebackend.util.Requests;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MoviesService {

    @Value("${services.movies.endpoint}")
    private String moviesEndpoint;

    public MovieDTO[] getAllMovies(){
        String response = Requests.getString(moviesEndpoint + "/getMovies");
        Gson gson = new Gson();
        return gson.fromJson(response, MovieDTO[].class);
    }


}
