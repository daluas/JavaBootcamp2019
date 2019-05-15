public class CommandCenter implements Observer {

    private Subject battle;

    public void update() {
        String battleReport = (String) battle.getUpdate(this);
        if(battleReport== null){
            System.out.println("No new battle report");
        } else {
            System.out.println(((Battle)battle).getName() + " report:  "+battleReport);
        }

    }

    public void setSubject(Subject sub) {
        this.battle = sub;
    }
}
