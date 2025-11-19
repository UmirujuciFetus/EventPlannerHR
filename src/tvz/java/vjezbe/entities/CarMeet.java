package tvz.java.vjezbe.entities;

import java.time.LocalDateTime;

public class CarMeet extends Event {
    private String meetName;
    private Integer numberOfCars;

    public CarMeet(String eventName, LocalDateTime eventDate, String meetName, Integer numberOfCars) {
        super(eventName, eventDate);
        this.meetName = meetName;
        this.numberOfCars = numberOfCars;
    }

    public void setMeetName(String meetName) {
        this.meetName = meetName;
    }
    public String getMeetName() {
        return meetName;
    }

    public void setNumberOfCars(Integer numberOfCars) {
        this.numberOfCars = numberOfCars;
    }
    public Integer getNumberOfCars(){
        return numberOfCars;
    }

    @Override
    public void getEventType() {
        System.out.println("Ovaj događaj je Car Meet!");
    }

    @Override
    public String getStringForm() {
        return "Ime meeta: " + eventName + "\n Datum i vrijeme meeta: " + eventDate;
    }
}
