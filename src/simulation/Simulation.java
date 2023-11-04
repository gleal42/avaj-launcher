package simulation;

import flyable.Flyable;
import simulator.Simulator;
import tower.WeatherTower;

import java.util.ArrayList;

public class Simulation {
    private ArrayList<Flyable> flyables;
    private WeatherTower weatherTower;

    public Simulation(ArrayList<Flyable> flyables) {
        this.flyables = flyables;
        this.weatherTower = new WeatherTower();
    }

    public void run() {
        for (Flyable flyable :
                flyables) {
            weatherTower.register(flyable);
        }
        this.weatherTower.changeWeather();
        for (Flyable flyable :
                flyables) {
            weatherTower.unregister(flyable);
        }
    }
}
