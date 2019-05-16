import java.util.ArrayList;
import java.util.List;

public class UnitScript {

    static Army joinExisting(Unit newUnit, Unit occupyingUnit, String name){
        Army comp = (Army) occupyingUnit.getComposite();
        if(comp != null){
            comp = new Army(name);
            comp.addUnit(occupyingUnit);
            comp.addUnit(newUnit);
        }

        return comp;
    }
}
