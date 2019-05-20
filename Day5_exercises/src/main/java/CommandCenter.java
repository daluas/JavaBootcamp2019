public class CommandCenter implements Observer {

    private String name;

    private Subject subject;

    public CommandCenter(String name){
        this.name=name;
    }

    public void update() {
        String msg = (String) subject.getUpdate(this);
        if(msg == null){
            System.out.println("No message");
        }else
            System.out.println(msg);
    }

    public void setSubject(Subject sub) {
        this.subject=sub;
    }

}
