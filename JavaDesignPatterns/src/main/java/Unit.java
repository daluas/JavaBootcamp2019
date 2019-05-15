import java.util.List;

abstract class Unit {
    protected Integer depth = 0;

    abstract public Integer bombardStrength();

    protected void setDepth(Integer depth){
        this.depth = depth;
    }

    public Integer getDepth(){
        return this.depth;
    }

    public List<Unit> getComposite(){
        return null;
    }
}
