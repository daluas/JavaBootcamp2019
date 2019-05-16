public interface Subject {
    void addCommander (Commander commander);
    void removeCommander(Commander commander);
    void notifyCommander();
    Object getUpdate();
}
