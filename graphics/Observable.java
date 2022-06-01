package graphics;

import java.util.Vector;

public class Observable implements Runnable {

    private Vector<Observer> list; // = new Vector<java.util.Observer>();

    public void registerObserver(Observer ob) {
        list.add(ob);
    }

    public void unregisterObserver(Observer ob) {
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

