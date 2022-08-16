package vitalii.bozadzhy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import vitalii.bozadzhy.exception.AuthenticationException;
import vitalii.bozadzhy.exception.RegistrationException;
import vitalii.bozadzhy.lib.Injector;
import vitalii.bozadzhy.model.CinemaHall;
import vitalii.bozadzhy.model.Movie;
import vitalii.bozadzhy.model.MovieSession;
import vitalii.bozadzhy.model.User;
import vitalii.bozadzhy.security.AuthenticationService;
import vitalii.bozadzhy.service.CinemaHallService;
import vitalii.bozadzhy.service.MovieService;
import vitalii.bozadzhy.service.MovieSessionService;
import vitalii.bozadzhy.service.OrderService;
import vitalii.bozadzhy.service.ShoppingCartService;

public class Main {
    private static final Injector injector = Injector.getInstance("vitalii.bozadzhy");

    public static void main(String[] args) {
        MovieService movieService =
                (MovieService) injector.getInstance(MovieService.class);

        Movie fastAndFurious = new Movie("Fast and Furious");
        fastAndFurious.setDescription("An action film about street racing, heists, and spies.");
        movieService.add(fastAndFurious);
        System.out.println(movieService.get(fastAndFurious.getId()));
        movieService.getAll().forEach(System.out::println);

        CinemaHall firstCinemaHall = new CinemaHall();
        firstCinemaHall.setCapacity(100);
        firstCinemaHall.setDescription("first hall with capacity 100");

        CinemaHall secondCinemaHall = new CinemaHall();
        secondCinemaHall.setCapacity(200);
        secondCinemaHall.setDescription("second hall with capacity 200");

        CinemaHallService cinemaHallService =
                (CinemaHallService) injector.getInstance(CinemaHallService.class);
        cinemaHallService.add(firstCinemaHall);
        cinemaHallService.add(secondCinemaHall);

        System.out.println(cinemaHallService.getAll());
        System.out.println(cinemaHallService.get(firstCinemaHall.getId()));

        MovieSession tomorrowMovieSession = new MovieSession();
        tomorrowMovieSession.setCinemaHall(firstCinemaHall);
        tomorrowMovieSession.setMovie(fastAndFurious);
        tomorrowMovieSession.setShowTime(LocalDateTime.now().plusDays(1L));

        MovieSession yesterdayMovieSession = new MovieSession();
        yesterdayMovieSession.setCinemaHall(firstCinemaHall);
        yesterdayMovieSession.setMovie(fastAndFurious);
        yesterdayMovieSession.setShowTime(LocalDateTime.now().minusDays(1L));

        MovieSessionService movieSessionService =
                (MovieSessionService) injector.getInstance(MovieSessionService.class);
        movieSessionService.add(tomorrowMovieSession);
        movieSessionService.add(yesterdayMovieSession);

        System.out.println(movieSessionService.get(yesterdayMovieSession.getId()));
        System.out.println(movieSessionService.findAvailableSessions(
                fastAndFurious.getId(), LocalDate.now()));

        AuthenticationService authenticationService =
                (AuthenticationService) injector.getInstance(AuthenticationService.class);

        User alice = null;
        try {
            alice = authenticationService.register("alice@ukr.net", "1234");
        } catch (RegistrationException e) {
            throw new RuntimeException("Can't register user ", e);
        }

        User aliceLogin = null;
        try {
            aliceLogin = authenticationService.login("alice@ukr.net", "1234");
        } catch (AuthenticationException e) {
            throw new RuntimeException("Can't authenticate user. Email or password incorrect: ", e);
        }

        ShoppingCartService shoppingCartService =
                (ShoppingCartService) injector.getInstance(ShoppingCartService.class);
        shoppingCartService.addSession(tomorrowMovieSession, alice);
        System.out.println(shoppingCartService.getByUser(alice));

        OrderService orderService =
                (OrderService) injector.getInstance(OrderService.class);
        orderService.completeOrder(shoppingCartService.getByUser(alice));
        System.out.println(orderService.getOrdersHistory(alice));
    }
}
