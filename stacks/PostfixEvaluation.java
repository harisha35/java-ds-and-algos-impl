package stacks;

public class PostfixEvaluation {

    public static int evaluatePostfix(String s) {
        int i = 0;
        int length = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        while(i < length) {
            char c = s.charAt(i);
            if (isOperator(c)) {
                int op2 = stack.pop();
                int op1 = stack.pop();
                int result = 0;
                if (c == '+') {
                    result = op1 + op2;
                } else if (c == '-') {
                    result = op1 - op2;
                } else if (c == '*') {
                    result = op1 * op2;
                } else if (c == '/') {
                    result = op1 / op2;
                }
                stack.push(result);
            } else {
                stack.push(Character.getNumericValue(c));
            }
            i++;
        }
        return stack.pop();
    }

    private static boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/');
    }

    public static void main(String[] args) {
        String s = "123*+5-";
        System.out.println("Postfix evalation of " + s + " is " + evaluatePostfix(s));
    }
}
