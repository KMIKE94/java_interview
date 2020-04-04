package google;

import com.sun.source.tree.BinaryTree;

import java.util.*;

public class Interview {
    public static void main(String... args) {
        Interview interview = new Interview();

        int[] ar1 = {1,1,3,3,3,2,1,6,6,7,5,3,3,1,1};
        System.out.println(interview.findMostFrequent(ar1));

        int[] ar2 = {1,9,1,9};
        int n = 10;
        interview.findSum(ar2, n).forEach(System.out::println);

        int[] arr3 = {1,1,9,5,9,12,12};
        System.out.println(interview.findSingle(arr3));
    }

    /**
     * Given an array of integers, find the most frequent
     */
    private int findMostFrequent(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(arr).forEach(val -> {
            if(map.containsKey(val)) {
                int currentTally = map.get(val);
                map.put(val, currentTally+1);
            } else {
                map.put(val, 1);
            }
        });

        return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    /**
     * Given an array and an integer n, return all the values that sum to n
     *
     */
    private List<Integer> findSum(int[] arr, int n) {
        List<Integer> result = new ArrayList<>();
        // {1,2,9,12} 10 => 1 9
        Arrays.sort(arr);
        // using -1 as number already used
        for(int i=0,j=1; j<arr.length;i++,j++) {
            if(arr[i] == -1 || arr[j] == -1) {
                continue;
            } else if (arr[i] + arr[j] == n) {
                result.add(arr[i]); result.add(arr[j]);
                arr[i] = -1; arr[j] = -1;
            }
        }

        return result;
    }

    /**
     * Given an array where each element should appear twice, find
     * the Integer that appears once
     */
    private int findSingle(int[] arr) {
        int result = 0;

        // do this is constant space, log(n)
        // only get one pass through
        // not necessarily sorted
        for(int i : arr) {
            result ^= i;
        }

        return result;
    }

}
