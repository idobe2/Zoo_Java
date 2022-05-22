package food;

/**
 * An easy interface to read animal food-type.
 * Used to identify if the animal is edible or not.
 * 
 * @version 1.2 19 May 2022
 * @author Ido Ben Nun, Bar Cohen
 * @see diet.IDiet
 */
public interface IEdible {
	public EFoodType getFoodType();
	
}
