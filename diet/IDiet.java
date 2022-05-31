package diet;

import animals.Animal;
import food.EFoodType;
import food.IEdible;

/**
 * An interface to use with animals feed and diet.
 * 
 * @version 1.2 19 May 2022
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
	boolean canEat(EFoodType food);

	/**
	 * eat function to perform an animal feed 
	 * with a specific food type (other animal).
	 * Each class that uses this interface implements it in a different
	 * way because each class describes a different type of animal.
	 *
	 * @param animal	The eating animal.
	 * @param food		The eaten animal food type.
	 * @return 		(double) difference between
	 * 					new and prev weight.
	 */
	double eat(Animal animal, IEdible food);

}
