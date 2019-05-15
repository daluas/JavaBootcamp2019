import java.util.ArrayList;

public interface Subject {
    void register(Observer observer);
    void unregister(Observer observer);
    void notifyObserver();
    Object getUpdate();
}
