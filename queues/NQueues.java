package queues;

public class NQueues {
    int[] arr;
    int[] front;
    int[] rear;
    int[] next;
    int free = 0;

    public NQueues(int k, int n) {
        arr = new int[n];
        front = new int[k];
        rear = new int[k];
        next = new int[n];

        for (int i = 0; i < k; i++) {
            front[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            next[i] = i + 1;
        }
        next[n-1] = -1;
	}

    public void enQueue(int k, int item) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }
        int i = free;
        free = next[i];

        if (isEmpty(k)) {
            front[k-1] = i;
        } else {
            next[rear[k-1]] = i;
        }

        rear[k-1] = i;
        next[i] = -1;

        arr[i] = item;
    }

    public int deQueue(int k) {
        if (isEmpty(k)) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int i = front[k-1];

        front[k-1] = next[i];
        next[i] = free;

        free = i;
        return arr[i];
    }

    public boolean isEmpty(int k) {
        return (front[k-1] == -1);
    }

    public boolean isFull() {
        return (free == -1);
    }

    public static void main(String[] args) {
        NQueues queues = new NQueues(3, 10);
        queues.enQueue(1, 1);
        queues.enQueue(1, 11);
        queues.enQueue(1, 111);
        queues.enQueue(2, 2);
        queues.enQueue(2, 22);
        queues.enQueue(3, 3);
        queues.enQueue(3, 33);

        System.out.println(queues.deQueue(1));
        System.out.println(queues.deQueue(1));
        System.out.println(queues.deQueue(1));
        System.out.println(queues.deQueue(2));
        System.out.println(queues.deQueue(2));
        System.out.println(queues.deQueue(3));
        System.out.println(queues.deQueue(3));
        
    }
}
