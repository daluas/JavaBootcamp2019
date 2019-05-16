public class Main {
    public static void main(String[] args) {
        Army army1 = new Army("Army1");
        army1.addUnit(new LaserCannonUnit());
        army1.addUnit(new Cavalry());

        Army army2 = new Army("Army2");
        army2.addUnit(new Cavalry());
        army2.addUnit(new Cavalry());

        Army army3 = new Army("Army3");
        army3.addUnit(new Archer());
        army3.addUnit(new Archer());

        Army jointArmy = UnitScript.joinExisting(army1,army2, "jointArmy");

        System.out.println(jointArmy.bombardStrength());

        Battle battle = new Battle();

        Commander1 commandCenter = new CommandCenter();
        ((CommandCenter) commandCenter).setSubject(battle);

        battle.addCommander(commandCenter);

        System.out.println("Winner: ");
        battle.battle(army3, jointArmy);

    }
}
