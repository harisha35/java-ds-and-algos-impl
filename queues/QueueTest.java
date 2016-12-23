package queues;

public class QueueTest {
	public static void main(String[] args) {
		Queue<Integer> q = new Queue<Integer>();
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);
		// Should print 1
		System.out.println(q.deQueue());
		q.enQueue(4);
		q.enQueue(5);
		q.enQueue(6);
		// Should print 2
		System.out.println(q.deQueue());
	}
}