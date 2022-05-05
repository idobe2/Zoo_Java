package diet;

import animals.Animal;
import food.EFoodType;
import food.IEdible;

/**
 * A simple class to use with omnivore animals.
 * 
 * @version 1.0 03 April 2022
 * @author Ido Ben Nun, Bar Cohen
 * @see Carnivore
 */
public class Omnivore implements IDiet {
	
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
	public boolean canEat(EFoodType food) {
		if (food != EFoodType.NOTFOOD)
			return true;
		else return false;
	}
	
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
	public double eat(Animal animal, IEdible food) {
		EFoodType Etemp = food.getFoodtype();
		if (canEat(food.getFoodtype()))
		{
			if(Etemp == EFoodType.MEAT) {
				double temp = animal.getWeight() * 1.1;
				animal.makeSound();
				return temp - animal.getWeight()-temp;
				}
			
			else if(Etemp == EFoodType.VEGETABLE) {
				double temp = animal.getWeight() * 1.1;
				animal.makeSound();
				return temp - animal.getWeight();
			}
		}
		return 0;
	}
}
