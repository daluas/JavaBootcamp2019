public interface Observer {

   void getNotified(String battleResult);

   void setObservedObject(Subject observedObject);
}
