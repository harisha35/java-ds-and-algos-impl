package stacks;

public class LongestValidSubstring {

    private static int findMaxLength(String s) {
        int i = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        int result = 0;
        while(i < s.length()) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                int currentLength = 0;

                if (!stack.isEmpty()) {
                    currentLength = i - stack.peek();
                } else {
                    stack.push(i);
                }

                if (currentLength > result) {
                    result = currentLength;
                }
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "()(()))))";
        System.out.println("Longest valid substring for " + s + " is " + findMaxLength(s));
    }
}
