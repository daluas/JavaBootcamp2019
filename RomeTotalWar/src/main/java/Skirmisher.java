public class Skirmisher implements Unit{
    private Double attackPoints = 18.0;
    private Double defensePoints = 6.0;
    private Double stealthBonus = 9.0;

    public void add(Unit unit) {
        throw new java.lang.UnsupportedOperationException("Leaves can't add nodes");
    }

    public void remove(Unit unit) {
        throw new java.lang.UnsupportedOperationException("Leaves can't remove nodes");
    }

    public Unit getChild(int i) {
        throw new java.lang.UnsupportedOperationException("Leaves don't have children");
    }

    public Double getOffensePower() {
        return attackPoints;
    }

    public Double getDefensePower() {
        return defensePoints*stealthBonus;
    }

    public void setAttackPoints(Double attackPoints) {
        this.attackPoints = attackPoints;
    }

    public void setDefensePoints(Double defensePoints) {
        this.defensePoints = defensePoints;
    }

    public void setStealthBonus(Double stealthBonus) {
        this.stealthBonus = stealthBonus;
    }
}
