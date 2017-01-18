package stacks;

public class NextSmallerOfGreaterElement {

    private static int[] nextGreaterElement(int[] arr) {
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

        return next;
    }

    private static int[] nextSmallerOfNextGreater(int[] arr) {
        int i = 1;
        Stack<Integer> stack = new Stack<Integer>();

        stack.push(0);
        int[] next = new int[arr.length];
        for (int j = 0; j < arr.length; j++) {
            next[j] = -1;
        }
        while(i < arr.length) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                next[stack.pop()] = i;
            }
            stack.push(i);
            i++;
        }

        int[] nextGreaters = nextGreaterElement(arr);
        int[] results = new int[arr.length];

        for (int j = 0; j < arr.length; j++) {
            if (nextGreaters[j] != -1 && next[nextGreaters[j]] != -1) {
                results[j] = arr[next[nextGreaters[j]]];
            } else {
                results[j] = -1;
            }
        }
        return results;
	}

    public static void main(String[] args) {
        int[] arr = {4, 8, 2, 1, 9, 5, 6, 3};
        int[] next = nextSmallerOfNextGreater(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + "  -->  " + next[i]);
        }
    }
}
