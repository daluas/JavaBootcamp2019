import java.util.ArrayList;
import java.util.List;

public class Battle implements Subject {

    private List<Observer> observersList;

    public void register(Observer observer){

        if(observersList == null){

            observersList = new ArrayList<>();
        }
        observersList.add(observer);
    }

    public boolean notifyObservers(String battleResult){

        if(observersList == null){

            System.out.println("I DON`T HAVE ANY OBSERVERS");
            return false;
        }

        observersList.forEach(observer->observer
                .getNotified(battleResult));
        return true;
    }

    public boolean addArmies(Army firstArmy, Army secondArmy){


        if(firstArmy.getPower() - secondArmy.getPower() >= 0){

          return notifyObservers("ARMY1");


        }
         return notifyObservers("ARMY2");
    }


}
