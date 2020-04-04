package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MessingAround {
    public static void main(String... args) {
        int[] arr = {1,2,3,4,5,6};
        contiguousSubArrays(arr).forEach(v -> {
            for(int val:v) {
                System.out.print(val +" ");
            }
            System.out.println();
        });

    }

    static ArrayList<ArrayList<Integer>> contiguousSubArrays(int... arr) {
        ArrayList<Integer> checker = new ArrayList<>();
        ArrayList<ArrayList<Integer>> subArrays = new ArrayList<>();
        for(int i=0;i<arr.length;i++) {
            for(int j=i+1;j<arr.length;j++){
                int[] sub = Arrays.copyOfRange(arr, i, j);
                Arrays.stream(sub).forEach(checker::add);
                subArrays.add(checker);
                System.out.println("######");
                Arrays.stream(sub).forEach(System.out::println);
                System.out.println("*****");
                checker.forEach(System.out::println);
                checker.clear();
            }
        }
        return subArrays;
    }



    static boolean isPrime(int number) {
        int root = (int) Math.sqrt(number);
        for(int i=2; i<root;i++) {
            if(number%i == 0) {
                return false;
            }
        }
        return true;
    }
}
