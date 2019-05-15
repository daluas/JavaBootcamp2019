public class Army extends CompositeUnit{
    @Override
    public Integer bombardStrength() {
        Integer armyStrength = 0;
        for(Unit unit : this.units){
            armyStrength += unit.bombardStrength();
        }
        return armyStrength;
    }
}
