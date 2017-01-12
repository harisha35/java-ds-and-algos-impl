package stacks;

import java.util.ArrayList;

public class Stack<Item> {
    ArrayList<Item> stack;

    public Stack() {
        stack = new ArrayList<Item>();
	}

    public void push(Item item) {
        stack.add(stack.size(), item);
    }

    public Item pop() {
        if (size() > 0) {
            return stack.remove(stack.size()-1);
        } else {
            return null;
        }
    }

    public Item peek() {
        if (size() > 0) {
            return stack.get(stack.size()-1);
        } else {
            return null;
        }
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return (stack.size() == 0);
    }

    public void printStack() {
        System.out.println();
        for (int i = 0; i< stack.size(); i++) {
            System.out.print(stack.get(i) + " ");
        }
        System.out.println();
    }

}
