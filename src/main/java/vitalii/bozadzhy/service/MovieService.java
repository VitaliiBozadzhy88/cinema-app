package vitalii.bozadzhy.service;

import java.util.List;
import vitalii.bozadzhy.model.Movie;

public interface MovieService {
    Movie add(Movie movie);

    Movie get(Long id);

    List<Movie> getAll();
}
