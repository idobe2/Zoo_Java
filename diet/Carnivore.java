package diet;

import animals.Animal;
import animals.Lion;
import food.EFoodType;
import food.IEdible;
import utilities.MessageUtility;

import java.util.Random;

/**
 * A simple class to use with carnivore animals.
 * 
 * @version 1.0 03 April 2022
 * @author Ido Ben Nun, Bar Cohen
 * @see Herbivore
 */
public class Carnivore implements IDiet {
	
	/**
	 * A simple Getter for a random boolean.
	 * Helper function.
	 * 
	 * @return true or false.
	 */
	public boolean getRandomBoolean() {
	    Random random = new Random();
	    return random.nextBoolean();
	}
	
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
		if (food == EFoodType.MEAT)
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
		if (canEat(food.getFoodtype()))
		{
			if (animal instanceof Lion)
			{
				if (getRandomBoolean())
					((Lion) animal).addScar();
			}
			double temp = animal.getWeight(); // original weight
			animal.setWeight(animal.getWeight()*1.1); // new weight
			animal.makeSound();
			return animal.getWeight()-temp; // return new weight - original weight
		}
		return 0;
	}
}
