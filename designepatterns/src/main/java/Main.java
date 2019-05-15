public class Main {
    public static void main(String[] args) {
        Army mainArmy = new Army();
        mainArmy.addUnit(new Archer());
        mainArmy.addUnit(new LaserCannonUnit());

        Army subArmy = new Army();
        subArmy.addUnit(new Archer());

        Army underArmy = new Army();
        underArmy.addUnit(new Archer());

        Army joinedArmy = UnitScript.joinExisting(mainArmy, subArmy);
        Army joinedSecondArmy = UnitScript.joinExisting(joinedArmy, underArmy);

        System.out.println("Boombard Strength: " + joinedSecondArmy.bombardStrength());

        Battle battle = new Battle();

        Observer commandCenter = new CommandCenter();
        ((CommandCenter) commandCenter).setSubject(battle);
        battle.register(commandCenter);

        System.out.print("The winner is: ");
        battle.addArmies(joinedSecondArmy, mainArmy);
    }
}
