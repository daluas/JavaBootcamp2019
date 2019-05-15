import java.util.ArrayList;
import java.util.List;

public class UnitScript {
    public List<Unit> joinExisting(Unit newUnit, Unit occupyingUnit){
        List<Unit> comp = new ArrayList<>();
        comp = occupyingUnit.getComposite();

        return comp;
    }
}
