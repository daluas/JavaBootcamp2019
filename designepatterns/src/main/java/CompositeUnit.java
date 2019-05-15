import java.util.ArrayList;

public abstract class CompositeUnit extends Unit {
    ArrayList<Unit> units = new ArrayList<Unit>();

    public CompositeUnit getComposite() {
        return this;
    }

    void addUnit(Unit unit) {
        for(Unit currentUnit:this.units) {
            if(currentUnit.equals(unit)) {
                return;
            }
        }
        unit.setDepth(this.depth + 1);
        this.units.add(unit);
    }

    public void removeUnit(Unit unit) {
        for(Unit currentUnit:this.units) {
            if(currentUnit.equals(unit)) {
                this.units.remove(unit);
                break;
            }
        }

    }
}
