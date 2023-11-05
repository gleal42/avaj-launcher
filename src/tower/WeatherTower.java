package tower;

import coordinates.Coordinates;
import exceptions.InvalidWeather;
import flyable.Flyable;
import weather.WeatherProvider;

public class WeatherTower extends Tower {

    public WeatherTower() {
    }

    public void register(Flyable p_flyable) {
        super.register(p_flyable);
        p_flyable.registerTower(this);
    }

    public String getWeather(Coordinates p_coordinates) {
        WeatherProvider weatherProvider = WeatherProvider.getInstance();
        return weatherProvider.getCurrentWeather(p_coordinates);
    }

    public void changeWeather() throws InvalidWeather {
        WeatherProvider weatherProvider = WeatherProvider.getInstance();
        weatherProvider.changeWeather();
        conditionChanged();
    }


}