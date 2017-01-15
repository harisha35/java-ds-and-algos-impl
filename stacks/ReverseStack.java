package stacks;

public class ReverseStack {

    private void insertBottom(Stack stack, int k) {
        if (stack.isEmpty()) {
            stack.push(k);
            return;
        }
        int a = (int) stack.pop();
        insertBottom(stack, k);
        stack.push(a);
    }

    private void reverseStack(Stack stack) {
        if (stack.isEmpty()) {
            return;
        }
        int t = (int) stack.pop();
        reverseStack(stack);
        insertBottom(stack, t);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack : ");
        System.out.println();
        stack.printStack();
        ReverseStack reverse = new ReverseStack();
        reverse.reverseStack(stack);
        System.out.println("Stack after reversing: ");
        stack.printStack();
    }
}
