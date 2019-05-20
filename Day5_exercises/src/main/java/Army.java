public class Army extends CompositeUnit {
    public int bombardStrength(){
        int ret=0;
        for(Unit unit:this.units){
            ret+=unit.bombardStrength();
        }
        return ret;
    }
}
