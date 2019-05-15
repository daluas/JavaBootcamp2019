public class HeavyInfantry implements Unit {
    private Integer attackPoints = 25;
    private Integer defensePoints = 20;
    private Double chargeBonus = 3.0;
    private Double armourBonus = 2.0;

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
        return attackPoints*chargeBonus;
    }

    public Double getDefensePower() {
        return defensePoints*armourBonus;
    }

    public void setAttackPoints(Integer attackPoints) {
        this.attackPoints = attackPoints;
    }

    public void setDefensePoints(Integer defensePoints) {
        this.defensePoints = defensePoints;
    }

    public void setChargeBonus(Double chargeBonus) {
        this.chargeBonus = chargeBonus;
    }

    public void setArmourBonus(Double armourBonus) {
        this.armourBonus = armourBonus;
    }
}
