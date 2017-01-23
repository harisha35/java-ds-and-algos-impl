package hashing;

import java.util.Map;
import java.util.HashMap;

public class LargestSubarray {

    private static void findSubArray(int[] arr) {
        int maxLength = 0;
        int endPos = -1;
        int sum = 0;

        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = -1;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == 0) {
                maxLength = i + 1;
                endPos = i;
            }

            if (hashMap.containsKey(sum)) {
                if (maxLength < i - hashMap.get(sum)) {
                    maxLength = i - hashMap.get(sum);
                    endPos = i;
                }
            } else {
                hashMap.put(sum, i);
            }
        }

        if (endPos != -1) {
            int startPos = endPos - maxLength + 1;
            System.out.println(startPos + " to " + endPos);
        } else {
            System.out.println("No such subarray");
        }
    }

    public static void main(String[] args) {
        int arr[] =  {1, 0, 1, 1, 1, 0, 0};
        findSubArray(arr);
    }
}
