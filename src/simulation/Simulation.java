package simulation;

import exceptions.InvalidWeather;
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
        for (Flyable flyable :
                this.flyables) {
            weatherTower.register(flyable);
        }
    }

    public void run() {
        try {
            this.weatherTower.changeWeather();
        } catch (InvalidWeather inv) {
            System.out.println("Got Invalid Weather" + inv);
        }
    }
}
