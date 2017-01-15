package stacks;

public class NStacks {
    int[] arr;
    int[] top;
    int[] next;
    int free = 0;

    public NStacks(int k, int n) {
        arr = new int[n];
        top = new int[k];
        next = new int[n];

        for (int i = 0; i < k; i++) {
            top[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            next[i] = i + 1;
        }
        next[n-1] = -1;
	}

    public void push(int k, int item) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }
        int i = free;
        free = next[i];

        next[i] = top[k-1];
        top[k-1] = i;

        arr[i] = item;
    }

    public int pop(int k) {
        if (isEmpty(k)) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int i = top[k-1];

        top[k-1] = next[i];
        next[i] = free;

        free = i;
        return arr[i];
    }

    public boolean isEmpty(int k) {
        return (top[k-1] == -1);
    }

    public boolean isFull() {
        return (free == -1);
    }

    public static void main(String[] args) {
        NStacks stacks = new NStacks(3, 10);
        stacks.push(1, 1);
        stacks.push(1, 11);
        stacks.push(1, 111);
        stacks.push(2, 2);
        stacks.push(2, 22);
        stacks.push(3, 3);
        stacks.push(3, 33);

        System.out.println(stacks.pop(1));
        System.out.println(stacks.pop(1));
        System.out.println(stacks.pop(1));
        System.out.println(stacks.pop(2));
        System.out.println(stacks.pop(2));
        System.out.println(stacks.pop(3));
        System.out.println(stacks.pop(3));
        
    }
}
