package flyable;

import coordinates.Coordinates;
import exceptions.InvalidWeather;

public class Aircraft extends Flyable {
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinates;
    }

    @Override
    public void updateConditions() throws InvalidWeather {
        String currentWeather = weatherTower.getWeather(coordinates);
        switch (currentWeather) {
            case "SUN":
                handleSun();
                break;
            case "RAIN":
                handleRain();
                break;
            case "FOG":
                handleFog();
                break;
            case "SNOW":
                handleSnow();
                break;
            default:
                throw new InvalidWeather("Received invalid weather" + currentWeather);
        }
        fixCoordinates();
    }

    private void fixCoordinates() {

        if (this.coordinates.getLongitude() < 0) {
            this.coordinates = new Coordinates(0, coordinates.getLatitude(), coordinates.getHeight());
        }
        if (this.coordinates.getLatitude() < 0) {
            this.coordinates = new Coordinates(coordinates.getLongitude(), 0, coordinates.getHeight());
        }
        if (this.coordinates.getHeight() < 0) {
            this.removalNeed = true;
        } else if (this.coordinates.getHeight() > 100) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), 100);
        }
    }

    @Override
    protected void handleSnow() {
    }

    @Override
    protected void handleFog() {
    }

    @Override
    protected void handleRain() {
    }

    @Override
    protected void handleSun() {
    }

    @Override
    public String toString() {
        return "#" + name + "(" + id + ")";
    }
}