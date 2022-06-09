package graphics;

/**
 * An interface to use with animals,
 * Expands the options of an animal.
 *
 * @version 1.3 09 June 2022
 * @author Ido Ben Nun, Bar Cohen
 * @see IDrawable
 */
public interface IAnimalBehavior {
    String getAnimalName();
    int getSize();
    void eatInc();
    int getEatCount();
    boolean getChanges ();
    void setChanges (boolean state);
    void setSuspended() throws InterruptedException;
    void setResumed() throws InterruptedException;
}
