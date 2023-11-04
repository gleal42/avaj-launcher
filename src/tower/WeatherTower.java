package tower;

import coordinates.Coordinates;
import weather.WeatherProvider;

public class WeatherTower extends Tower {

    public WeatherTower()
    {
    }

    public String getWeather(Coordinates p_coordinates)
    {
        WeatherProvider weatherProvider = WeatherProvider.getInstance();
        return weatherProvider.getCurrentWeather(p_coordinates);
    }
    public void changeWeather()
    {
        WeatherProvider weatherProvider = WeatherProvider.getInstance();
        weatherProvider.changeWeather();
    }


}