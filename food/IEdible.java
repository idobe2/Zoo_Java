package food;

/**
 * An easy interface to read animal food-type.
 * Used to identify if the animal is edible or not.
 * 
 * @version 1.3 09 June 2022
 * @author Ido Ben Nun, Bar Cohen
 * @see diet.IDiet
 */
public interface IEdible {
	public EFoodType getFoodType();
	
}
