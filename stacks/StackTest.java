public class StackTest {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		// Should print 3
		System.out.println(stack.pop());
		stack.push(4);
		stack.push(5);
		stack.push(6);
		// Should print 6
		System.out.println(stack.pop());
	}
}