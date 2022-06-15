import java.util.ArrayList;

public class FlightDatabase {

    ArrayList<Flight> flights = new ArrayList<>();

    public FlightDatabase() {
        this.flights.add(new Flight("Berlin", "Tokyo",1880));
        this.flights.add(new Flight("Paris", "Berlin",549));
        this.flights.add(new Flight("Warsaw", "Paris",9521));
        this.flights.add(new Flight("Madrid", "Berlin",4712));
        this.flights.add(new Flight("Berlin", "Warsaw",3257));
        this.flights.add(new Flight("Paris", "Madrid",1598));
        this.flights.add(new Flight("Porto", "Warsaw",2569));
        this.flights.add(new Flight("Madrid", "Porto",1478));
        this.flights.add(new Flight("Warsaw", "Madrid",999));
    }

    public void checkIfFlightExist(String start, String end) {
        for (int i = 0; i < this.flights.size(); i++) {
            Flight flight = this.flights.get(i);
            if (start.equals(flight.departure) && end.equals(flight.arrival)) {
                System.out.println("Searching flight is possible !!! :: " + flight.departure + "-" + flight.arrival);
                return;
            }
        }
        System.out.println("Flight does not exist");
    }

    public void displayFlights(ArrayList<Flight> results) {
        if (results.isEmpty()) {
            System.out.println("Flight no found!");
        }
        for (Flight flight : results) {
            flight.getFlightInfo();
        }
    }

    public ArrayList<Flight> getFlightFromCity(String depCity) {
        ArrayList<Flight> results = new ArrayList<>();
        for (Flight flight : this.flights) {
            if (depCity.equals(flight.departure)) {
                results.add(flight);
            }
        }
        return results;
    }

    public ArrayList<Flight> getFlightToCity(String arriveCity) {
        ArrayList<Flight> results = new ArrayList<>();
        for (Flight flight : this.flights) {
            if (arriveCity.equals(flight.arrival)) {
                results.add(flight);
            }
        }
        return results;
    }

    public void displayFlightsFromCity(String cityDep) {
        ArrayList<Flight> results = getFlightFromCity(cityDep);
        displayFlights(results);
    }

    public void displayFlightsToCity(String cityArrive) {
        ArrayList<Flight> results = getFlightToCity(cityArrive);
        displayFlights(results);
    }

    public ArrayList<String> getCities() {
        ArrayList<String> cities = new ArrayList<>();
        for (Flight flight : this.flights) {
            if (!cities.contains(flight.departure)) {
                cities.add(flight.departure);
            }
            if (!cities.contains(flight.arrival)) {
                cities.add(flight.arrival);
            }
        }
        return cities;
    }

    public Flight getCheapestFlight() {
        Flight cheapestFlight = null;
        for (Flight flight : flights) {
            if (cheapestFlight == null || flight.price < cheapestFlight.price) {
                cheapestFlight = flight;
            }
        }
        return cheapestFlight;
    }

    public Flight getCheapestFlightFromCity(String city) {
        ArrayList<Flight> fromCity = getFlightFromCity(city);
        Flight cheapestFlight = null;
        for (Flight flight : fromCity) {
            if (cheapestFlight == null || flight.price < cheapestFlight.price) {
                cheapestFlight = flight;
            }
        }
        return cheapestFlight;
    }

    public ArrayList<Journey> getFlights(String startCity, String endCity) {
        ArrayList<Flight> starting = getFlightFromCity(startCity);
        ArrayList<Flight> ending = getFlightToCity(endCity);
        ArrayList<Journey> results = new ArrayList<>();
            for (Flight first : starting) {
                for (Flight second :ending) {
                    if (first.arrival.equals(second.departure)) {
                        results.add(new Journey(first, second));
                    }
                }
            }
            return results;
    }
}

