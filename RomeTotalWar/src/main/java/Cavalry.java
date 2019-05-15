public class Cavalry implements Unit {
    private Double attackPoints = 25.0;
    private Double defensePoints = 15.0;
    private Double speedBonus = 5.0;

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
        return attackPoints*speedBonus;
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

    public void setSpeedBonus(Double speedBonus) {
        this.speedBonus = speedBonus;
    }
}
