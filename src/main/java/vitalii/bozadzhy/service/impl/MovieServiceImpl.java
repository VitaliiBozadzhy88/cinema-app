package vitalii.bozadzhy.service.impl;

import java.util.List;
import vitalii.bozadzhy.dao.MovieDao;
import vitalii.bozadzhy.lib.Inject;
import vitalii.bozadzhy.lib.Service;
import vitalii.bozadzhy.model.Movie;
import vitalii.bozadzhy.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
    @Inject
    private MovieDao movieDao;

    @Override
    public Movie add(Movie movie) {
        return movieDao.add(movie);
    }

    @Override
    public Movie get(Long id) {
        return movieDao.get(id).get();
    }

    @Override
    public List<Movie> getAll() {
        return movieDao.getAll();
    }
}
