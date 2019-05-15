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

    public String battle(Army army1, Army army2){

        return "Ana are mere";
    }
}
