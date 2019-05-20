public class Main {
    public static void main(String args[]) {
        Army main_army = new Army();
        main_army.addUnit(new Archer());
        main_army.addUnit(new LaserCannonUnit());
        Army sub_army = new Army();
        sub_army.addUnit(new Archer());
        Army under_army = new Army();
        under_army.addUnit(new Archer());
        Army joined_army = (Army) UnitScript.joinExisting (main_army, sub_army);
        Army join_second_army = (Army) UnitScript.joinExisting (joined_army, under_army);
        System.out.println("Boombard Strength: " + join_second_army.bombardStrength());
        Battle battle = new Battle();
        Observer commandCenter = new CommandCenter("center");
        ((CommandCenter) commandCenter).setSubject(battle);
        battle.register(commandCenter);
        System.out.print("The winner is: ");
        battle.addArmies(join_second_army, main_army);
    }
}
