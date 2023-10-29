package coordinates;

public class Coordinates {
    private final int longitude;
    private final int latitude;
    private final int height;

    public Coordinates(int p_longitude, int p_latitude, int p_height)
    {
        longitude=p_longitude;
        latitude=p_latitude;
        height=p_height;
    }
    public int getLongitude()
    {
        return longitude;
    }
    public int getLatitude()
    {
        return latitude;
    }
    public int getHeight()
    {
        return height;
    }
}