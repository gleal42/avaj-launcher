package flyable;
import coordinates.Coordinates;

public class Aircraft extends Flyable
{
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    @Override
    public void updateConditions()
    {
    }
    protected Aircraft(long p_id, String p_name, Coordinates p_coordinates)
    {

    }

}