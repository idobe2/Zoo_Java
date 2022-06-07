package animals;

import plants.Plant;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class Caretaker {
    private final Stack<ArrayList <Memento>> stack = new Stack<>();
    private static final int MAX = 3;

    private Plant food = null;

    public void addMemento(ArrayList<Memento> mementos) {
        for (Memento memento : mementos)
            memento.getAnimal().notifyObservers(" is backed up");
        stack.add(mementos);
    }

    public ArrayList <Memento> getMemento() {
        try {
            return stack.pop();
        } catch (EmptyStackException exception) {
            System.out.println("Stack is empty!");
            return null;
        }
    }

    public boolean isEmpty()
    {
        return stack.isEmpty();
    }

    public boolean isAvailable()
    {
        return stack.size() < MAX;
    }

    public void setFood(Plant food) {this.food = food;}

    public Plant getFood() { return food; }
}