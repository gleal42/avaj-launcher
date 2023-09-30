import java.util.Objects;

class AircraftFactory
{
    private static volatile  AircraftFactory instance;
    private String value;
    private AircraftFactory(String value)
    {
    }
    public static AircraftFactory getInstance(String value) {
        AircraftFactory result = instance;
        if (result != null) {
            return result;
        }
        synchronized (AircraftFactory.class) {
            if (instance == null) {
                instance = new AircraftFactory(value);
            }
            return instance;
        }
    }
    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
        if (Objects.equals(p_type, "JetPlane"))
            return new JetPlane(1, p_name, p_coordinates);
        else if (Objects.equals(p_type, "Helicopter")) {
            return new Helicopter(2, p_name, p_coordinates);
        }
        else if (Objects.equals(p_type, "Baloon")) {
            return new Baloon(2, p_name, p_coordinates);
        }
        return null;
    }
}
