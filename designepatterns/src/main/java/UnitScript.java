public class UnitScript {
    static Army joinExisting(Unit newUnit, Unit occupyingUnit) {
        Army comp = (Army) occupyingUnit.getComposite();
        if(comp != null) {
            comp = new Army();
            comp.addUnit(occupyingUnit);
            comp.addUnit(newUnit);
        }
        return comp;
    }
}
