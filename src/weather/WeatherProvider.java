package weather;

import coordinates.Coordinates;

class WeatherProvider
{
    private static volatile  WeatherProvider instance;
    private String[] weather;
    private WeatherProvider()
    {
    }
    public static WeatherProvider getInstance(String value) {
        WeatherProvider result = instance;
        if (result != null) {
            return result;
        }
        synchronized (WeatherProvider.class) {
            if (instance == null) {
                instance = new WeatherProvider();
            }
            return instance;
        }
    }
    public String getCurrentWeather(Coordinates p_coordinates) {
        return weather[0];
    }
}
