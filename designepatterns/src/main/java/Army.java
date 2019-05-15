public class Army extends  CompositeUnit {
    public int bombardStrength() {
        int returnValue = 0;
        for(Unit unit:this.units) {
            returnValue += unit.bombardStrength();
        }
        return returnValue;
    }
}
