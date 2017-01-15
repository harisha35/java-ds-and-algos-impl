package stacks;

public class InfixEvaluation {

    public static int evaluateInfix(String s) {
        int i = 0;
        int length = s.length();
        Stack<Character> operators = new Stack<Character>();
        Stack<Integer> operands = new Stack<Integer>();
        while(i < length) {
            char c = s.charAt(i);
            if (!isOperator(c) && c != ')' && c != '(') {
                operands.push(Character.getNumericValue(c));
            }
            // Assuming all the operators have same priority (i.e, +, -, *, / are treated equally)
            else if (isOperator(c)) {
                if (!operators.isEmpty() && operators.peek() != '(') {
				    int op2 = operands.pop();
				    int op1 = operands.pop();
				    operands.push(compute(op1, op2, operators.pop()));
                }
                operators.push(c);
            } else if (c == '(') {
                operators.push(c);
                
            } else {
                char op = operators.pop();
                while (op != '(') {
                    int op2 = operands.pop();
				    int op1 = operands.pop();
				    operands.push(compute(op1, op2, op));
                    op = operators.pop();
                }
            }
            i++;
        }

        while (!operators.isEmpty()) {
            int op2 = operands.pop();
            int op1 = operands.pop();
            operands.push(compute(op1, op2, operators.pop()));
        }
        return operands.pop();
    }

    private static boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/');
    }

    private static int compute(int op1, int op2, char op) {
        if (op == '+') {
            return op1 + op2;
        } else if (op == '-') {
            return op1 - op2;
        } else if (op == '*') {
            return op1 * op2;
        } else {
            return op1 / op2;
        }
    } 

    public static void main(String[] args) {
        String s = "2+3-(6+5)+8";
        System.out.println("Infix evalation of " + s + " is " + evaluateInfix(s));
    }
}
