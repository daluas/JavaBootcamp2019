public abstract class Unit {
    int depth;

    public CompositeUnit getComposite() {
        return null;
    }

    void setDepth(int depth) {
        this.depth = depth;
    }

    public int getDepth() {

        return depth;
    }

    public abstract int bombardStrength();
}
