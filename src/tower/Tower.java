package tower;

import flyable.Flyable;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    private List<Flyable> observers;

    public Tower() {
        this.observers = new ArrayList<>();
    }

    public void register(Flyable p_flyable)
    {
        System.out.println("Tower says: "+p_flyable.toString()+" registered to weather tower.");
        observers.add(p_flyable);
    }
    public void unregister(Flyable p_flyable)
    {
        System.out.println("Tower says: "+p_flyable.toString()+" unregistered from weather tower.");
        observers.remove(p_flyable);
    }
    protected void conditionChanged()
    {
        for (Flyable observer : observers
             ) {
            observer.updateConditions();
        }
    }    
}