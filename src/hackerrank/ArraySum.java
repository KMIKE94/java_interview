package hackerrank;

import java.util.Arrays;

/**
 * Given an array and a value you should be able to decide
 * if you can sum to that value
 */
public class ArraySum {

    public static void main(String arsg[]) {
        int[] test_1 = {1,2,3,9};
        int[] test_2 = {1,2,4,8};
        int sum = 8;

        System.out.println(canSum(test_1, sum));
        System.out.println(canSum(test_2, sum));
    }

    private static boolean canSum(int[] arr, int sum) {
        // first sort the arr
        Arrays.sort(arr);

        // guaranteed a sorted array, can now start
        // by grabbing the last values
        for(int i=arr.length-1;i>=0;i--) {
            // start from the end
            int val = arr[i];
            if(val == sum) {
                return true;
            } else if(val > sum) {
                continue; // want to skip this value because it
                          // cannot be used in our calculations
            } else {
                // val < sum
                for(int x=i-1;x>=0;x--) {
                    val += arr[x];
                    if(val == sum) {
                        return true;
                    } else if(val > sum) {
                        return false;
                    }
                }
            }
        }

        return false;
    }

}
