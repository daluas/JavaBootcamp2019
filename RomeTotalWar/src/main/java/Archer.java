public class Archer implements Unit {
    private Double attackPoints = 15.0;
    private Double defensePoints = 6.0;
    private Double rangedBonus = 5.0;

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
        return attackPoints*rangedBonus;
    }

    public Double getDefensePower() {
        return defensePoints;
    }

    public void setAttackPoints(Double attackPoints) {
        this.attackPoints = attackPoints;
    }

    public void setDefensePoints(Double defensePoints) {
        this.defensePoints = defensePoints;
    }

    public void setRangedBonus(Double rangedBonus) {
        this.rangedBonus = rangedBonus;
    }
}
