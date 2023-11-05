package flyable;

import coordinates.Coordinates;

public class Baloon extends Aircraft {

    public Baloon(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    @Override
    public String toString() {
        return "Baloon" + super.toString();
    }

    @Override
    protected void handleSun() {
        System.out.println(this + ": So hot today... This day is about to be Popping!");
        this.coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
    }

    @Override
    protected void handleRain() {
        System.out.println(this + ": If you paint my face, the rain will make it look like I'm crying!");
        this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
    }

    @Override
    protected void handleFog() {
        System.out.println(this + ": So foggy! I can't see the rest of my balloon friends in Cappadocia");
        this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
    }

    @Override
    protected void handleSnow() {
        System.out.println(this + ": It's snowing so much! I'm like a frozen egg right now!");
        this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
    }

}