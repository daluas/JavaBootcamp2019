import java.util.ArrayList;
import java.util.List;

public class Army implements Unit{

    private List<Unit> units = new ArrayList<>();
    private String name;

    public Army(String name) {
        this.name = name;
    }

    public void add(Unit unit) {
        units.add(unit);
    }

    public void remove(Unit unit) {
        unit.remove(unit);
    }

    public Unit getChild(int i) {
        return units.get(i);
    }

    public Double getOffensePower() {
        Double offensePower = 0.0;
        for(Unit unit : units)
            offensePower +=unit.getOffensePower();
        return offensePower;
    }

    public Double getDefensePower() {
        Double defensePower = 0.0;
        for(Unit unit : units)
            defensePower +=unit.getDefensePower();
        return defensePower;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public void setUnits(List<Unit> units) {
        this.units = units;
    }

    public String getName() {
        return name;
    }

    public static Unit JoinForces(Unit originalArmy, Unit reinforcements, String name){
        List<Unit> joinedUnits = new ArrayList<>();
        joinedUnits.addAll(((Army)reinforcements).getUnits());
        joinedUnits.addAll(((Army)originalArmy).getUnits());
        Unit joinedArmy = new Army(name);
        ((Army) joinedArmy).setUnits(joinedUnits);
        return joinedArmy;
    }
}
