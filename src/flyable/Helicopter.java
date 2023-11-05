package flyable;

import coordinates.Coordinates;

public class Helicopter extends Aircraft {
    public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    @Override
    public String toString() {
        return "Helicopter" + super.toString();
    }

    @Override
    protected void handleSun() {
        System.out.println(this + ": So hot and dry! At least we have this helix to cool us off!");
        this.coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
    }

    @Override
    protected void handleRain() {
        System.out.println(this + ": So rainy! At least we have a spinning umbrella!");
        this.coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
    }

    @Override
    protected void handleFog() {
        System.out.println(this + ": Look at all this fog! Perfect weather for 007 to ambush!");
        this.coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight());
    }

    @Override
    protected void handleSnow() {
        System.out.println(this + ": Do you see all this snow? Copy! Yes I do! Copy");
        this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
    }

}