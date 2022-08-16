package vitalii.bozadzhy.dao;

import java.util.List;
import java.util.Optional;
import vitalii.bozadzhy.model.CinemaHall;

public interface CinemaHallDao {
    CinemaHall add(CinemaHall cinemaHall);

    Optional<CinemaHall> get(Long id);

    List<CinemaHall> getAll();
}
