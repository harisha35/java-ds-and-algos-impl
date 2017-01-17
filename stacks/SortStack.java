package stacks;

public class SortStack {

    private void sortedInsert(Stack stack, int k) {
        if (stack.isEmpty() || (int) stack.peek() > k) {
            stack.push(k);
            return;
        }
        int a = (int) stack.pop();
        sortedInsert(stack, k);
        stack.push(a);
    }

    private void sortStack(Stack stack) {
        if (stack.isEmpty()) {
            return;
        }
        int t = (int) stack.pop();
        sortStack(stack);
        sortedInsert(stack, t);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(5);
        stack.push(3);
        stack.push(4);
        System.out.println("Stack : ");
        System.out.println();
        stack.printStack();
        SortStack sort = new SortStack();
        sort.sortStack(stack);
        System.out.println("Stack after sorting: ");
        stack.printStack();
    }
}
