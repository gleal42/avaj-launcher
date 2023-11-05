package tower;

import exceptions.InvalidWeather;
import flyable.Flyable;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Tower {
    private final List<Flyable> observers;

    public Tower() {
        this.observers = new ArrayList<>();
    }

    public void register(Flyable p_flyable) {
        System.out.println("Tower says: " + p_flyable.toString() + " registered to weather tower.");
        observers.add(p_flyable);
    }

    public void unregister(Flyable p_flyable) {
        System.out.println("Tower says: " + p_flyable.toString() + " unregistered from weather tower.");
    }

    protected void conditionChanged() throws InvalidWeather {
        ListIterator<Flyable> iter = observers.listIterator();
        while (iter.hasNext()) {
            Flyable currentFlyable = iter.next();
            currentFlyable.updateConditions();
            if (currentFlyable.needsRemoval()) {
                unregister(currentFlyable);
                iter.remove();
            }
        }
    }
}