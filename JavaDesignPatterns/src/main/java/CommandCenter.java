public class CommandCenter implements Commander1 {

    private Subject subject;

    @Override
    public void update() {
        String winner = (String) subject.getUpdate();
        if(winner != ""){
            System.out.println(winner);
        }
    }

    void setSubject(Subject subject){
        this.subject = subject;
    }
}
