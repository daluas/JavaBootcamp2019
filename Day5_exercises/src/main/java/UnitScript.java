public class UnitScript {
    static CompositeUnit joinExisting(Unit newUnit, Unit occupyingUnit)
    {
        CompositeUnit comp=occupyingUnit.getComposite();
        if(comp!=null)
        {
            comp = new Army();
            comp.addUnit(occupyingUnit);
            comp.addUnit(newUnit);
        }
        return comp;
    }

}

