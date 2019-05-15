import java.util.ArrayList;
import java.util.List;

abstract class CompositeUnit extends Unit {
    protected List<Unit> units;

    public List<Unit> getComposite(){
        return this.units;
    }
    public void addUnit(Unit unit){
        for(Unit thisUnit : units){
            if(unit == thisUnit){
                break;
            }
        }
        unit.setDepth(this.depth + 1);
        this.units.add(unit);
    }

    public void removeUnit(Unit unit){
        this.units.remove(unit);
    }

}
