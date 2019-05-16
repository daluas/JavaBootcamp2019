import java.util.ArrayList;
import java.util.List;

abstract class CompositeUnit extends Unit {
    ArrayList<Unit> units = new ArrayList<Unit>();

    public CompositeUnit getComposite(){
        return this;
    }
    public void addUnit(Unit unit){
        for(Unit thisUnit : units){
            if(thisUnit.equals(unit)){
                return;
            }
        }
        unit.setDepth(this.depth + 1);
        this.units.add(unit);
    }

    public void removeUnit(Unit unit){
        this.units.remove(unit);
    }

}
