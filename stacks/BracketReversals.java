package stacks;

public class BracketReversals {

    public static Integer noOfBracketReversals(String s) {
        int i = 0;
        int length = s.length();
        Stack<Character> stack = new Stack<Character>();
        while(i < length) {
            char c = s.charAt(i);
            if (c == '{') {
                stack.push(c);
            } else if (c == '}') {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            i++;
        }
        if(stack.isEmpty()) {
            return 0;
        } else if (stack.size() % 2 != 0) {
            return null;
        }

        int countOfOpeningBraces = 0;
        while (!stack.isEmpty() && stack.peek() != '}') {
            stack.pop();
            countOfOpeningBraces++;
        }
        return ((countOfOpeningBraces + 1) / 2 + (stack.size() + 1 )/2);
    }

    public static void main(String[] args) {
        String s = "}{{}}{{{";
        Integer bracketReversals = noOfBracketReversals(s);
        if(bracketReversals != null) {
            System.out.println("String " + s + " can be balanced with " + bracketReversals + " reversals");
        } else {
            System.out.println("String " + s + " can't be made balanced using reversals.");
        }
    }
}
