public class CommandCenter implements Observer {
    private Subject subject;

    public void update(String winner) {
        System.out.println(winner);
    }

    void setSubject(Subject subject) {
        this.subject = subject;
    }
}
