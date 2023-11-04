package flyable;
import coordinates.Coordinates;

public class Helicopter extends Aircraft
{
    @Override
    public void updateConditions()
    {
    }
    public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    @Override
    public String toString() {
        return "Helicopter" + super.toString();
    }
}