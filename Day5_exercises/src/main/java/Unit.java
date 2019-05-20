abstract class Unit {
    protected int depth=0;
    public CompositeUnit getComposite(){
        return null;
    }

    abstract int bombardStrength();

    protected void setDepth(int depth)
    {
        this.depth=depth;
    }

    public int getDepth()

    {
        return this.depth;
    }



}
