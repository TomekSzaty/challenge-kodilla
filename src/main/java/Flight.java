public class Flight {

    String departure;
    String arrival;
    int price;

    public Flight(String departure, String arrival, int price) {
        this.departure = departure;
        this.arrival = arrival;
        this.price = price;

    }

    public void getFlightInfo() {
        System.out.println("Flight from:: " + this.departure +
                ", to:: " + this.arrival +
                " -- costs:: " + price + "$");
    }


}
