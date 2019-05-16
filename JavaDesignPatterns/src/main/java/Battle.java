import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Battle implements Subject {
    private String winner;
    private ArrayList<Commander1> commanders;

    public Battle(){
        this.commanders = new ArrayList<Commander1>();
        winner = "";
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner){
        this.winner = winner;
        notifyCommander();
    }

    public void addCommander(Commander1 commander){
        this.commanders.add(commander);
    }

    @Override
    public void removeCommander(Commander1 commander) {
        this.commanders.remove(commander);
    }

    public void notifyCommander() {
        for(Commander1 comander : commanders){
            comander.update();
        }
    }

    public void battle(Army army1, Army army2){

        if(army1.bombardStrength() < army2.bombardStrength()){
            winner = army2.getName();
        }else {
            winner = army1.getName();
        }
        notifyCommander();
    }

    @Override
    public Object getUpdate() {
        return this.winner;
    }
}
