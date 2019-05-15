import java.util.ArrayList;
import java.util.List;

public class Battle implements Subject {

    private List<Observer> observers = new ArrayList<>();
    private String battleReport;
    private Boolean changed;
    private String name;

    public Battle(String name) {
        this.name = name;
    }

    public void register(Observer obj) {
        if(obj == null) throw new NullPointerException("Null Observer");
            if(!observers.contains(obj)) {
                observers.add(obj);
            }
    }

    public void unregister(Observer obj) {
        observers.remove(obj);
    }

    public void notifyObservers() {
        if (!changed)
            return;
        observers = new ArrayList<>(this.observers);
        this.changed=false;
		for (Observer obj : observers) {
        obj.update();
     }
    }

    public Object getUpdate(Observer obj) {
        return this.battleReport;
    }

    public void postBattleReport(Unit firstArmy, Unit secondArmy){
        Double damageFirstArmy = firstArmy.getDefensePower() - secondArmy.getOffensePower();
        Double damageSecondArmy = secondArmy.getDefensePower() - firstArmy.getOffensePower();
        this.battleReport =(damageFirstArmy > damageSecondArmy) ? ((Army)firstArmy).getName() + " army won!" : ((Army)secondArmy).getName()+" army won!";
        this.changed=true;
        notifyObservers();
    }

    public String getName() {
        return name;
    }
}
