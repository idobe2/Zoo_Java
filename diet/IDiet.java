package diet;

import animals.Animal;
import food.EFoodType;
import food.IEdible;

import java.text.DecimalFormat;

/**
 * An interface to use with animals feed and diet.
 * 
 * @version 1.0 03 April 2022
 * @author Ido Ben Nun, Bar Cohen
 * @see IEdible
 */
public interface IDiet {
	
	/**
	 * canEat Boolean method.
	 * perform a check whether the animal can eat the food or not.
	 *
	 * @param food
	 * 			EFoodType food-type
	 * @return true if the food is appropriate
	 * 		(depending on the realizing class),
	 * 		otherwise false.
	 */
	public boolean canEat(EFoodType food);
	
	/**
	 * eat function to perform an animal feed 
	 * with a specific food type (other animal).
	 * 
	 * @param animal
	 * 			The eating animal.
	 * @param food
	 * 			The eaten animal food type.
	 * @return
	 */
	public double eat(Animal animal, IEdible food);

}
