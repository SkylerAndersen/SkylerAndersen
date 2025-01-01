abstract public class Listener implements ButtonListener {
    private boolean hasUpdates;
    private boolean pressedRun;
    private boolean pressedTerminate;
    private boolean guiClosed;
    public Listener () {}
    abstract public boolean hasUpdates();
    abstract public boolean pressedRun();
    abstract public boolean pressedTerminate();
    abstract public boolean guiClosed();
    abstract public void markRecieved();
    abstract public void declareUpdates();
    abstract public void notifyOfRun();
    abstract public void notifyOfTerminate();
    abstract public void notifyOfGUIClosed();
}