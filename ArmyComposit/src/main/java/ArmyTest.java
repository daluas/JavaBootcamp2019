import java.util.HashMap;
import java.util.function.Supplier;
import java.util.Map;

public class ArmyTest {

    public static void main(String[] args) {

        Army mainArmy = new Army();

        mainArmy.addUnit(new Archer());

        mainArmy.addUnit(new LaserCannonUnit());

        System.out.println("====MAIN ARMY====");
        System.out.println(mainArmy.showArmy());
        System.out.println(mainArmy.getPower());

        Army subArmy = new Army();

        subArmy.addUnit(new Archer());

        System.out.println("====SUB ARMY====");
        System.out.println(subArmy.showArmy());
        System.out.println(subArmy.getPower());

        Army underArmy = new Army();

        underArmy.addUnit(new LaserCannonUnit());

        System.out.println("====UNDER ARMY====");
        System.out.println(underArmy.showArmy());
        System.out.println(underArmy.getPower());

        Army joinedArmy = Army.joinExisting(mainArmy,subArmy);

        System.out.println("====JOINED ARMY====");
        System.out.println(joinedArmy.showArmy());
        System.out.println(joinedArmy.getPower());

        Army joinedSecondArmy = Army.joinExisting(joinedArmy,underArmy);

        System.out.println("====JOINED SECOND ARMY====");
        System.out.println(joinedArmy.showArmy());
        System.out.println(joinedArmy.getPower());
        System.out.println("BOMBARD strnegth : "+joinedSecondArmy.getBombardStrenght());
        System.out.println("Archer strnegth : "+joinedSecondArmy.getArcherStrenght());

        System.out.println("====BATTLE AND COMMAND CENTER====");

        Battle battle = new Battle();

        Observer commandCenter = new CommandCenter();

        battle.register(commandCenter);

        commandCenter.setObservedObject(battle);

        battle.addArmies(joinedArmy,joinedSecondArmy);

        battle.addArmies(joinedSecondArmy,joinedArmy);








    }
}
