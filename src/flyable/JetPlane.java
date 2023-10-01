package flyable;
import coordinates.Coordinates;

public class JetPlane extends Aircraft
{
    @Override
    public void updateConditions()
    {
    }
    public JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }
}