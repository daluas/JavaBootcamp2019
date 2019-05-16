public class Army extends CompositeUnit{
    public String name;

    public Army(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public Integer bombardStrength() {
        Integer armyStrength = 0;
        for(Unit unit : this.units){
            armyStrength += unit.bombardStrength();
        }
        return armyStrength;
    }
}
