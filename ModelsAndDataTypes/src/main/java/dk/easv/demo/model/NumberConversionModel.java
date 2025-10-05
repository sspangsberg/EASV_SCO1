package dk.easv.demo.model;

public class NumberConversionModel {

    /**
     * Converts from kilometers to miles
     * @param km
     * @return
     */
    public double getMilesFromKilometers(double inputParam) {
        return inputParam / 1.609344f;
    }

    /**
     * Converts from miles to kilometers
     * @param miles
     * @return
     */
    public double getKilometersFromMiles(double miles) {
        return miles * 1.609344f;
    }


    /**
     * Returns a greeting message
     * @param name
     * @return
     */
    public String getGreetingsMessage(String name) {
        return "Hello, " + name + ". Greetings from the top Java developer class in town";
    }
}








