package vitalii.bozadzhy.service.impl;

import java.time.LocalDate;
import java.util.List;
import vitalii.bozadzhy.dao.MovieSessionDao;
import vitalii.bozadzhy.lib.Inject;
import vitalii.bozadzhy.lib.Service;
import vitalii.bozadzhy.model.MovieSession;
import vitalii.bozadzhy.service.MovieSessionService;

@Service
public class MovieSessionServiceImpl implements MovieSessionService {
    @Inject
    private MovieSessionDao sessionDao;

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        return sessionDao.findAvailableSessions(movieId, date);
    }

    @Override
    public MovieSession get(Long id) {
        return sessionDao.get(id).get();
    }

    @Override
    public MovieSession add(MovieSession session) {
        return sessionDao.add(session);
    }
}
