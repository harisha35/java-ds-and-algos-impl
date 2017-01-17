package stacks;

public class NextGreaterElement {

    public static int[] nextGreaterElement(int[] arr) {
        int i = 1;
        Stack<Integer> stack = new Stack<Integer>();

        stack.push(0);
        int[] next = new int[arr.length];
        for (int j = 0; j < arr.length; j++) {
            next[j] = -1;
        }
        while(i < arr.length) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                next[stack.pop()] = i;
            }
            stack.push(i);
            i++;
        }
        for (int j = 0; j < arr.length; j++) {
            if (next[j] != -1) {
                next[j] = arr[next[j]];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        int[] arr = {11, 13, 21, 3};
        int[] next = nextGreaterElement(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + "  -->  " + next[i]);
        }
    }
}
