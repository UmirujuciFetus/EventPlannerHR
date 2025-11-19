package tvz.java.vjezbe.services;

import tvz.java.vjezbe.entities.Concert;
import tvz.java.vjezbe.entities.CarMeet;
import tvz.java.vjezbe.entities.MoviePremiere;

import java.util.Scanner;


public interface EventService {
    void createEvent(Scanner sc);
    Concert createConcert(Scanner sc);
    MoviePremiere createMoviePremiere(Scanner sc);
    CarMeet createCarMeet(Scanner sc);
}
