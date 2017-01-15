package stacks;

public class StockSpans {

    public static int[] getSpans(int[] stockPrices) {
        int[] spans = new int[stockPrices.length];
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        spans[0] = 1;

        for (int i = 1; i < stockPrices.length; i++) {
            while (!stack.isEmpty() && stockPrices[stack.peek()] <= stockPrices[i]) {
                stack.pop();
            }

            spans[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        return spans;
    }

    public static void main(String[] args) {
        int[] stockPrices = {100, 80, 60, 70, 60, 75, 85};
        int[] spans = getSpans(stockPrices);

        for (int i = 0; i < stockPrices.length; i++) {
            System.out.print(spans[i] + "  ");
        }
        System.out.println();
    }
}
