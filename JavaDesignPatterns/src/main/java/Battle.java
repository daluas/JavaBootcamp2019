import java.util.ArrayList;
import java.util.List;

public class Battle {
    private String winner;
    private List<Commander> commanders = new ArrayList<>();

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner){
        this.winner = winner;
        notifyCommanders();
    }

    public void addCommander(Commander commander){
        commanders.add(commander);
    }

    private void notifyCommanders() {
        for(Commander comander : commanders){
            comander.update();
        }
    }

    public void battle(Army army1, Army army2){

        if(army1.bombardStrength() < army2.bombardStrength()){
            winner = "Army2";
        }else {
            winner = "Army1";
        }
        notifyCommanders();
    }
}
