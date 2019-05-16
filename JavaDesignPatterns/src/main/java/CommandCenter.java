public class CommandCenter implements Commander1 {

    public CommandCenter(Battle battle){
        this.battle = battle;
        this.battle.addCommander(this);
    }

    @Override
    public void update() {
        System.out.println("The winner of the battle is: " + battle.getWinner());
    }
}
