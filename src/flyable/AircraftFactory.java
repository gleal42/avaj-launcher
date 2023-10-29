package flyable;

import coordinates.Coordinates;
import exceptions.InvalidAircraftException;

import java.util.Objects;

public class AircraftFactory {
    int nextAircraftId;
    private static volatile AircraftFactory instance;
    private String value;

    private AircraftFactory() {
        this.nextAircraftId = 0;
    }

    public static AircraftFactory getInstance() {
        AircraftFactory result = instance;
        if (result != null) {
            return result;
        }
        synchronized (AircraftFactory.class) {
            if (instance == null) {
                instance = new AircraftFactory();
            }
            return instance;
        }
    }

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) throws InvalidAircraftException {
        int currentAircraftId = this.nextAircraftId++;
        if (Objects.equals(p_type, "JetPlane")) {
            return new JetPlane(currentAircraftId, p_name, p_coordinates);
        } else if (Objects.equals(p_type, "Helicopter")) {
            return new Helicopter(currentAircraftId, p_name, p_coordinates);
        } else if (Objects.equals(p_type, "Baloon")) {
            return new Baloon(currentAircraftId, p_name, p_coordinates);
        } else {
            this.nextAircraftId--;
            throw new InvalidAircraftException(p_type);
        }
    }
}
