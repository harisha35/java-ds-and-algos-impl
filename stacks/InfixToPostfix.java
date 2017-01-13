package stacks;

public class InfixToPostfix {

    public static void postfixValue(String s) {
        int i = 0;
        int length = s.length();
        Stack<Character> stack = new Stack<Character>();
        while(i < length) {
            char c = s.charAt(i);
            // Print if the character is operand
            if(isOperand(c)) {
                System.out.print(c);
            }
            // If the character is a right parantesis, pop and print all characters in stack until left paranthesis is encountered
            else if (c == ')') {
                while(stack.peek() != '(') {
                    System.out.print(stack.pop());
                }
                stack.pop();
            }
            // if character is an operator or left paranthesis, pop and output tokens until one of low priority than character is encountered
            // or a left paranthesis is encountered or the stack is empty
            else {
                if (c == '+' || c == '-') {
                    while(!stack.isEmpty() && stack.peek() != '(') {
                        System.out.print(stack.pop());
                    }
                } else if (c == '*' || c == '/') {
                    while(!stack.isEmpty() && stack.peek() != '(' && stack.peek() != '+' && stack.peek() != '-') {
                        System.out.print(stack.pop());
                    }
                }
                stack.push(c);
            }
            i++;
        }
        while(!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }

    public static boolean isOperand(char c) {
        return ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)); 
    }

    public static void main(String[] args) {
        String s = "A*B-(C+D)+E";
        System.out.print("Postfix value for String " + s + " is ");
        postfixValue(s);
        System.out.println();
    }
}
