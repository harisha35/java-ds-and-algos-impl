package queues;

import java.util.ArrayList;

public class Queue<Item> {
    ArrayList<Item> queue;

    public Queue() {
        queue = new ArrayList<Item>();
	}

    public void enQueue(Item item) {
        queue.add(size(), item);
    }

    public Item deQueue() {
        if (size() > 0) {
            return queue.remove(0);
        } else {
            return null;
        }
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return (queue.size() <= 0);
    }

    public Item front() {
        if (!isEmpty()) {
            return queue.get(queue.size()-1);
        } else {
            return null;
        }
    }

    public void printQueue() {
        System.out.println();
        for (int i = 0; i < size(); i++) {
            System.out.print(queue.get(i) + " ");
        }
        System.out.println();
    }

}
