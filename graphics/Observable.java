package graphics;

import java.util.Vector;

/**
 * We use this class instead of java.util.Observable built-in class.
 *
 *  @version 1.3 09 June 2022
 *  @author Ido Ben Nun, Bar Cohen
 *  @see Observer
 */
public class Observable implements Runnable {

    private Vector<Observer> list; // = new Vector<java.util.Observer>();

    /**
     * This function is used to register
     * the observer to subject.
     * @param ob (Observer) to be registered.
     */
    public void registerObserver(Observer ob) {
        list.add(ob);
    }

    /**
     * This function is used to unregister
     * the observer from subject.
     * @param ob (Observer) to be unregistered.
     */
    public synchronized void unregisterObserver(Observer ob) {
        list.remove(ob);
    }

    private void notifyObservers(String msg) {
        for (Observer ob : list)
            ob.notify(msg);
    }

   public void notify(String msg) {
        notifyObservers(msg);
   }

    @Override
    public void run() {}
}

