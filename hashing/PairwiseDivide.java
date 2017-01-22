package hashing;

import java.util.Map;
import java.util.HashMap;

public class PairwiseDivide {

    private static boolean canPairs(int[] arr, int k) {

        if (arr.length % 2 != 0) {
            return false;
        }

        int i = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();

        while (i < arr.length) {
            if (hashMap.containsKey(arr[i] % k)) {
                int count = hashMap.get(arr[i] % k);
                hashMap.put(arr[i] % k, count + 1);
            } else {
                hashMap.put(arr[i] % k, 1);
            }
            i++;
        }

        i = 0;

        while (i < arr.length) {
            int remainder = arr[i] % k;
            if (k == remainder * 2 || remainder == 0) {
                if (hashMap.get(remainder) % 2 != 0) {
                    return false;
                }
            } else if (hashMap.get(remainder) != hashMap.get(k - remainder)){
                return false;
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        int arr[] =  {92, 75, 65, 48, 45, 35};
        int k = 10;
        System.out.println(canPairs(arr, k));
    }
}
