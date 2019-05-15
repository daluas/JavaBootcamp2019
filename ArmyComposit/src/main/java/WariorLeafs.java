class Archer implements WarriorComposit{

    private Integer life = 600;

    private Integer attack = 50;

    private WarriorType warriorType = WarriorType.ARCHER;

    public Integer getArcherAttack()
    {
        return attack;
    }

    public Integer getArcherLife()
    {
        return life;
    }

    public Integer getPower()
    {
        return (life / 2) * (attack / 2) / 2;
    }

    public String showArmy()
    {
        return "Archer, life: " + life+", attack: " + attack;
    }

    public WarriorType getType(){

        return warriorType;
    }


}

class LaserCannonUnit  implements WarriorComposit{

    private Integer life = 1200;

    private Integer attack = 100;

    private WarriorType warriorType = WarriorType.BOMBARD;

    public Integer getLaserCannonUnitAttack(){

        return attack;
    }

    public Integer getLaserCannonUnitLife(){

        return life;
    }

    public Integer getPower(){

        return (life / 4) * attack /2;
    }

    public String showArmy(){

        return "LesetCannonUnit, life: " + life + ", attack: " + attack;
    }

    public WarriorType getType(){

        return warriorType;
    }

}