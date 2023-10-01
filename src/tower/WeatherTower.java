package tower;

import coordinates.Coordinates;
import java.util.Random;

public class WeatherTower extends Tower {
    private double humidityThreshold;
    private double temperatureThreshold;
    private double longitudeFactor;
    private double latitudeFactor;
    private double heightFactor;

    public WeatherTower() {
        changeWeather();
    }

    public String getWeather(Coordinates p_coordinates)
    {
        double humidity = calculateHumidity(p_coordinates);
        double temperature = calculateTemperature(p_coordinates);
        if (temperature > temperatureThreshold)
        {
            if (humidity > humidityThreshold)
            {
                return "RAIN";
            }
            else
            {
                return "SUN";
            }
        } else
        {
            if (humidity > humidityThreshold)
            {
                return "FOG";
            }
            else
            {
                return "SNOW";
            }
        }
    }

    private double calculateTemperature(Coordinates coordinates) {
        return (longitudeFactor/2) * coordinates.getLongitude() - (heightFactor/2) * coordinates.getHeight();
    }

    private double calculateHumidity(Coordinates coordinates) {
        return latitudeFactor * coordinates.getLatitude();
    }

    public void changeWeather()
    {
        Random random = new Random();
        humidityThreshold=random.nextDouble();
        temperatureThreshold=random.nextDouble();

        longitudeFactor=random.nextDouble();
        latitudeFactor=random.nextDouble();
        heightFactor= random.nextDouble();
    }
}