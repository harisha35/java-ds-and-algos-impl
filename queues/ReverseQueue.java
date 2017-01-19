package queues;

public class ReverseQueue {

    private static void reverse(Queue q) {
        if (q.isEmpty()) {
            return;
        }

        int temp = (int) q.deQueue();
        reverse(q);
        q.enQueue(temp);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);

        System.out.println("Queue before reversal : ");
        queue.printQueue();
        System.out.println();

        reverse(queue);

        System.out.println("Queue after reversal : ");
        queue.printQueue();
    }
}
