package vitalii.bozadzhy.service.impl;

import java.util.List;
import vitalii.bozadzhy.dao.CinemaHallDao;
import vitalii.bozadzhy.lib.Inject;
import vitalii.bozadzhy.lib.Service;
import vitalii.bozadzhy.model.CinemaHall;
import vitalii.bozadzhy.service.CinemaHallService;

@Service
public class CinemaHallServiceImpl implements CinemaHallService {
    @Inject
    private CinemaHallDao cinemaHallDao;

    @Override
    public CinemaHall add(CinemaHall cinemaHall) {
        return cinemaHallDao.add(cinemaHall);
    }

    @Override
    public CinemaHall get(Long id) {
        return cinemaHallDao.get(id).get();
    }

    @Override
    public List<CinemaHall> getAll() {
        return cinemaHallDao.getAll();
    }
}
