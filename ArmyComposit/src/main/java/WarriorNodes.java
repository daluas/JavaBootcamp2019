import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;


class Army implements WarriorComposit {

    private List<WarriorComposit> army;

    private WarriorType warriorType = WarriorType.ARMY;

    public void addUnit(WarriorComposit warrior){

        if(army == null ){

            army = new ArrayList<>();
        }
        army.add(warrior);
    }

    public String showArmy(){

        return Optional.ofNullable(army)
                .map(Army::showArmyUnits)
                .orElse("Empty Army");
    }

    public Integer getPower(){

        return Optional.ofNullable(army)
                .map(Army::getArmyPower)
                .orElse(0);
    }

    public WarriorType getType(){

        return warriorType;
    }

    public Integer getArcherStrenght(){

        return Optional.ofNullable(army)
                .map(Army::getArcherArmyStrenth)
                .orElse(0);
    }

    public Integer getBombardStrenght(){

        return Optional.ofNullable(army)
                .map(Army::getBombardArmyStrenth)
                .orElse(0);
    }

    public static Army joinExisting(Army firstArmy, Army secondArmy){

       Army newArmy = new Army();
       newArmy.army = new ArrayList<>();
       newArmy.army
               .addAll(getExistingArmy(firstArmy));
       newArmy.army
               .addAll(getExistingArmy(secondArmy));

       return newArmy;
    }

    private static String showArmyUnits(List<WarriorComposit> army){

        return army.stream()
                .map(WarriorComposit::showArmy)
                .collect(Collectors.joining(" NEXT UNIT "));
    }

    private static Integer getArmyPower(List<WarriorComposit> army){

        return army.stream()
                .mapToInt(WarriorComposit::getPower)
                .sum();
    }

    private static List<WarriorComposit> getExistingArmy(Army existArmy){

        return Optional.ofNullable(existArmy.army)
                .orElse(new ArrayList<>());
    }

    private static Integer getArcherArmyStrenth(List<WarriorComposit> army){

        return army.stream()
                .filter(warrior -> warrior.getType() == WarriorType.ARCHER)
                .mapToInt(WarriorComposit::getPower)
                .sum();
    }

    private static Integer getBombardArmyStrenth(List<WarriorComposit> army){

        return army.stream()
                .filter(warrior -> warrior.getType() == WarriorType.BOMBARD)
                .mapToInt(WarriorComposit::getPower)
                .sum();
    }



}
