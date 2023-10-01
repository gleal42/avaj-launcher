package tower;

import flyable.Flyable;
import java.util.List;

public class Tower {
    private List<Flyable> observers;
    public void register(Flyable p_flyable)
    {
        System.out.println("Tower says: ");
        observers.add(p_flyable);
    }
    public void unregister(Flyable p_flyable)
    {
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