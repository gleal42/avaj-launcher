class WeatherProvider
{
    private static volatile  WeatherProvider instance;
    private String value;
    private WeatherProvider(String value)
    {
    }
    public static WeatherProvider getInstance(String value) {
        WeatherProvider result = instance;
        if (result != null) {
            return result;
        }
        synchronized (WeatherProvider.class) {
            if (instance == null) {
                instance = new WeatherProvider(value);
            }
            return instance;
        }
    }
    public String getCurrentWeather(Coordinates p_coordinates) {
        return value;
    }
}
