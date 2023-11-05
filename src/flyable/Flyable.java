package flyable;

import exceptions.InvalidWeather;
import tower.WeatherTower;

public abstract class Flyable {
    protected Boolean removalNeed;
    protected WeatherTower weatherTower;

    public Flyable() {
        this.removalNeed = false;
    }

    public abstract void updateConditions() throws InvalidWeather;

    public void registerTower(WeatherTower p_tower) {
        weatherTower = p_tower;
    }

    protected abstract void handleSnow();

    protected abstract void handleFog();

    protected abstract void handleRain();

    protected abstract void handleSun();

    public boolean needsRemoval() {
        return this.removalNeed;
    }
}