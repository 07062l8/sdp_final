// Observer Interface
public interface Observer {
    /**
     * Called when the subject updates its state.
     * @param status The status message to notify observers.
     */
    void update(String status);
}