package animals;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class Caretaker {
    private final Stack<ArrayList <Memento>> stack = new Stack<>();
    private static final int MAX = 3;

    public void addMemento(ArrayList<Memento> mementos) {
        if (stack.size() < MAX)
            stack.add(mementos);
        else System.out.println("You can't save more than 3 states!");
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
}