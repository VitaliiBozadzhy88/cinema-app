package vitalii.bozadzhy.service;

import java.util.List;
import vitalii.bozadzhy.model.CinemaHall;

public interface CinemaHallService {
    CinemaHall add(CinemaHall cinemaHall);

    CinemaHall get(Long id);
    
    List<CinemaHall> getAll();
}
