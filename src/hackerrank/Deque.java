package hackerrank;

import java.util.*;
import java.util.stream.IntStream;

public class Deque {
    public static void main(String... args) {
        java.util.Deque deque = new ArrayDeque();
        int n = 6;
        int m = 3;
        int[] arr = {5,3,5,2,3,2};


        ArrayList<Integer> subArray = new ArrayList<>();
        ArrayList<ArrayList<Integer>> collections = new ArrayList<>();
        // calculate subarrays
        for(int i=0,j=m;j<=n;i++,j++) {
            int[] a = Arrays.copyOfRange(arr,i,j);
            for(int x:a){
                System.out.print(x + " ");
            }
            System.out.println();
        }

    }
}
