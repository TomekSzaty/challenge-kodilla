import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        FlightDatabase flightDatabase = new FlightDatabase();

//        flightDatabase.checkIfFlightExist("Warsaw", "Paris");
//
//        flightDatabase.displayFlightsFromCity("Berlin");
//
//        flightDatabase.displayFlightsToCity("Madrid");

        ArrayList<String> cities = flightDatabase.getCities();
        System.out.println(cities);

        Flight cheapestFlight = flightDatabase.getCheapestFlight();
        cheapestFlight.getFlightInfo();

        Flight cheapestFlightFromCity = flightDatabase.getCheapestFlightFromCity("Madrid");
        cheapestFlightFromCity.getFlightInfo();

        ArrayList<Journey> flyWithStop = flightDatabase.getFlights("Berlin", "Paris");
        System.out.println(flyWithStop);
    }
}



