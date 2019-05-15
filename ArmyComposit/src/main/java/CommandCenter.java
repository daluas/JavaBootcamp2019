public class CommandCenter implements Observer {

    private Subject observedObject;

    public void setObservedObject(Subject observedObject){

        this.observedObject = observedObject;
    }

    public void getNotified(String battleResult){

        if(observedObject == null){

            System.out.println("I DON`T HAVE ANY OBJECT TO OBSERVE");
        }

        System.out.println("THE ARMY THAT WON IS : "+battleResult);
    }
}
