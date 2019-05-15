public interface Unit {
    void add(Unit unit);
    void remove(Unit unit);
    Unit getChild(int i);
    Double getOffensePower();
    Double getDefensePower();
}
