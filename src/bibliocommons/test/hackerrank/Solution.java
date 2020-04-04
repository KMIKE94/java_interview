package bibliocommons.test.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String args[]) {

        List<Integer> arr = new ArrayList<Integer>();
        arr.add(7);
        arr.add(2);
        arr.add(3);
        arr.add(10);
        arr.add(2);
        arr.add(4);
        arr.add(8);
        arr.add(1);
//        List<Integer> copyList = new ArrayList<Integer>(arr);
//        Collections.sort(copyList);
//
//        int rightCounter = arr.size()-1;
//        int leftCounter = 0;
//
//        int largest = copyList.get(rightCounter);
//        int smallest = copyList.get(leftCounter);
//
//        int largestOriginalIndex = arr.indexOf(largest);
//        int smallestOriginalIndex = arr.indexOf(smallest);
//        System.out.print("Largest " + largest + " Index ");
//        System.out.print(largestOriginalIndex + "\n");
//        System.out.print("Smallest: " + smallest + " Index ");
//        System.out.print(smallestOriginalIndex + "\n");
//        while(smallestOriginalIndex > largestOriginalIndex) {
//            largest = copyList.get(rightCounter);
//            smallest = copyList.get(leftCounter);
//
//            largestOriginalIndex = arr.indexOf(largest);
//            smallestOriginalIndex = arr.indexOf(smallest);
//            rightCounter--;
//            leftCounter++;
//            System.out.print("Largest " + largest + " Index ");
//            System.out.print(largestOriginalIndex + "\n");
//            System.out.print("Smallest: " + smallest + " Index ");
//            System.out.print(smallestOriginalIndex + "\n");
//            System.out.println("Counters Right: " + rightCounter + " Left " + leftCounter);
//        }
//
//        System.out.println(largest-smallest);


        List<Integer> copyList = new ArrayList<Integer>(arr);
        Collections.sort(copyList);
        int biggestDiff = -1;

        int counter = 0;
        for(int i = arr.size()-1;i>1;i--){
            int largest = copyList.get(i); // largest value
            int largestOriginalIndex = arr.indexOf(largest);

            while(largestOriginalIndex > 1) {
                if(arr.get(largestOriginalIndex-1) < largest ) {
                    if((largest - arr.get(largestOriginalIndex-1)) > biggestDiff) {
                        biggestDiff = largest - arr.get(largestOriginalIndex-1);
                    }
                }
                counter++;

                largestOriginalIndex--;

            }
        }
        System.out.println("End " + biggestDiff);
        System.out.println("Number of loops: " + counter);

    }
}

class A {}
class B extends A{}
abstract class C extends B{}

//abstract class AB extends C {
//    String a = "";
//    default void mine() {
//
//    }
//}
