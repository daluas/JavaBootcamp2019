public class CommandCenter implements Observer {
    private Subject subject;

    public void update() {
        String winner = (String) subject.getUpdate();
        if(!winner.equals("")) {
            System.out.println(winner);
        }
    }

    void setSubject(Subject subject) {
        this.subject = subject;
    }
}
