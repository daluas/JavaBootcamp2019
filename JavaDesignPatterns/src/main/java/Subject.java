public interface Subject {
    void addCommander (Commander1 commander);
    void removeCommander(Commander1 commander);
    void notifyCommander();
    Object getUpdate();
}
