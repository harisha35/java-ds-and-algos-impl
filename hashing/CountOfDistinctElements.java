package hashing;

import java.util.Map;
import java.util.HashMap;

public class CountOfDistinctElements {

    private static void distinctElementsInWindow(int[] arr, int k) {
        int[] result = new int[arr.length - k + 1];
        int count, i = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        while (i < k) {
            if(hashMap.containsKey(arr[i])) {
                count = hashMap.get(arr[i]);
                hashMap.put(arr[i], count + 1); 
            } else {
                hashMap.put(arr[i], 1); 
            }
            i++;
        }

        System.out.println(hashMap.size());

        while (i < arr.length) {
            count = hashMap.get(arr[i - k]);
            if(count == 1) {
                hashMap.remove(arr[i - k]); 
            } else {
                hashMap.put(arr[i - k], count - 1); 
            }

            if(hashMap.containsKey(arr[i])) {
                count = hashMap.get(arr[i]);
                hashMap.put(arr[i], count + 1); 
            } else {
                hashMap.put(arr[i], 1); 
            }

            System.out.println(hashMap.size());
            i++;
        }
    }

    public static void main(String[] args) {
        int arr[] =  {1, 2, 1, 3, 4, 2, 3};
        int k = 4;
        distinctElementsInWindow(arr, k);
    }
}
