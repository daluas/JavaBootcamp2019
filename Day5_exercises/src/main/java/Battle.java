import java.util.ArrayList;

public class Battle implements Subject {

    private ArrayList<Observer> observers;

    private String message;

    private boolean changed;

    public Battle() {
        this.observers = new ArrayList<Observer>();
        message = "no winner";
    }

    public void unregister(Observer obj) {
        observers.remove(obj);
    }

    public void register(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer obj : observers) {
            obj.update();
        }
    }

    @Override
    public Object getUpdate(Observer obj) {
        return this.message;
    }

    void addArmies(Army second_army, Army main_army) {
        if (second_army.bombardStrength() < main_army.bombardStrength()) {
            message = "Second army";
        } else {
            message = "main army";
        }
        notifyObservers();
    }
}
