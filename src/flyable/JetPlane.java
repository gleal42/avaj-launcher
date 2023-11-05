package flyable;

import coordinates.Coordinates;

public class JetPlane extends Aircraft {
    public JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    @Override
    public String toString() {
        return "JetPlane" + super.toString();
    }

    @Override
    protected void handleSun() {
        System.out.println(this + ": So hot today it could melt steel beams! (unlike my fuel)");
        this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
    }

    @Override
    protected void handleRain() {
        System.out.println(this + ": The rain is crazy right now! Activate the wipers! Bill Gates will be mad!");
        this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5, coordinates.getHeight());
    }

    @Override
    protected void handleFog() {
        System.out.println(this + ": I can't see anything with this fog! We might be late to the rich people convention!");
        this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());
    }

    @Override
    protected void handleSnow() {
        System.out.println(this + ": Snowing like it's christmas! Santa is coming to the plane too!");
        this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);
    }

}