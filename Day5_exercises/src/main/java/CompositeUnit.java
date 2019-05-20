import java.util.ArrayList;
import java.util.List;

public abstract class CompositeUnit extends Unit {
    protected List<Unit> units=new ArrayList<Unit>();
    public CompositeUnit getComposite(){
        return this;
    }
    public void addUnit(Unit unit){
        for(Unit thisunit: this.units){
            if(unit.equals(thisunit)){
                return;
            }
        }
        unit.setDepth(this.depth+1);
        this.units.add(unit);
    }
   // public void accept(ArmyVisitor visitor){
   //    for(Unit thisunit: this.units){
   //        thisunit.accept(visitor);
   //   }
   //}
    public void removeUnit(Unit unit) {
        for(Unit thisunit:this.units) {
            if(thisunit.equals(unit)) {
                this.units.remove(unit);
            }
        }

    }

    

}
