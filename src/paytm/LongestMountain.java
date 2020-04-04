package paytm;


import java.util.ArrayList;
import java.util.List;

/**
 * Get the longest mountain given an array as input
 * the idea is that a mountain begins with the values rising
 * and ends when going down meets the next largest value
 *
 * input: [2, 1, 3, 4, 5, 7, 4, 3, 6]
 * output: 7
 *
 * input: [2,2,2]
 * output: 0
 */
public class LongestMountain {

    public static void main(String argsp[]) {
        LongestMountain longestMountain = new LongestMountain();
        int[] input = {2,2,2, 3, 4, 5, 5, 4, 3};
        System.out.println(longestMountain.getLongestMountain(input));
    }

    private int getLongestMountain(int[] arr) {
        // check that left is bigger than right
        // then check that right is less then left

        int longestMountain = 0;
        int counter;
        List<Integer> mountainRange = new ArrayList<>();
        for(int i=0;i<arr.length-1;i++){
            mountainRange = new ArrayList<>();
            counter = i;
            while(counter < arr.length-1 && arr[counter] < arr[counter+1]) {
                mountainRange.add(arr[counter]);
                counter++;

            }

            boolean shouldAddFinal = false;
            while(counter < arr.length-1 && arr[counter] > arr[counter+1]) {
                mountainRange.add(arr[counter]);
                counter++;
                shouldAddFinal = true;
            }
            if(shouldAddFinal)
                mountainRange.add(arr[counter]);

            if(mountainRange.size() > longestMountain) {
                longestMountain = mountainRange.size();
            }
        }
        return longestMountain;
    }
}
