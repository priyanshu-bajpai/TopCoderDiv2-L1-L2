public class TheAirTripDivTwo {
    public static int find(int[] flights, int fuel) {
        int numFlight=0;
        while(numFlight<flights.length) {
            if(fuel<flights[numFlight]) {
                break;
            }
            fuel-= flights[numFlight];
            numFlight++;
        }
        return numFlight;
    }
}
