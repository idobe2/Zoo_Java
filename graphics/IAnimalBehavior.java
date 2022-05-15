package graphics;

import mobility.Mobile;

/**
 * An interface to use with animals,
 * Expands the options of an animal.
 *
 * @version 1.1 01 May 2022
 * @author Ido Ben Nun, Bar Cohen
 * @see IDrawable
 */
public interface IAnimalBehavior {
    public String getAnimalName();
    public int getSize();
    public void eatInc();
    public int getEatCount();
    public boolean getChanges ();
    public void setChanges (boolean state);
    public void setSuspended() throws InterruptedException;
    public void setResumed() throws InterruptedException;
}
