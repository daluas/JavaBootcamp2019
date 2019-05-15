
import java.util.ArrayList;

public class Battle implements  Subject{
    private ArrayList<Observer> observers;
    private String winner;

    public Battle() {
        observers = new ArrayList<Observer>();
        winner = "";
    }

    public void register(Observer observer) {
        this.observers.add(observer);
    }

    public void unregister(Observer observer) {
        this.observers.remove(observer);
    }

    public void notifyObserver() {
        for(Observer observer:observers) {
            observer.update(winner);
        }
    }

    void addArmies(Army armyOne, Army armyTwo) {
        if(armyOne.bombardStrength() < armyTwo.bombardStrength()) {
            winner = "Army Two";
        } else {
            winner = "Army One";
        }
        notifyObserver();
    }
}
