package jonahgroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MarcEmail {

    public static void main(String args[]) {
        MarcEmail email = new MarcEmail();
        email.myBinaryStringSearch();
    }

    // binary string search
    private void binaryStringSearch(){
        String[] arr = {"hey", "cow", "sothing", "special", "ow"};

        Arrays.sort(arr, String.CASE_INSENSITIVE_ORDER);
        for(String a: arr) {
            System.out.print(a + " ");
        }
        System.out.println();
        System.out.println(Arrays.binarySearch(arr, "s"));
    }

    private void myBinaryStringSearch() {
        String[] arr = {"hey", "cow", "sothing", "special", "ow"};
        Arrays.sort(arr, String.CASE_INSENSITIVE_ORDER);

        Arrays.stream(arr).forEach(System.out::print);
        String key = "hey";
//        System.out.println(recursiveCompare(arr, key, 0, arr.length-1));
        System.out.println(iterativeCompare(arr, key, 0, arr.length-1));
    }

    private String iterativeCompare(String[] arr, String key, int begin, int end) {
        while(begin <= end) {
            int mid = begin + ((end-1)/2);
            int compare = key.compareTo(arr[mid]);

            if(compare == 0) {
                return "Contains";
            } else if(compare > 0) {
                begin = mid+1;
            } else {
                end = mid-1;
            }
        }
        return "Not Contained";
    }
}

class MyHashMap {
    String value;
    int key;
    String[] container;
    List<String> collisions = new LinkedList<>();

    public MyHashMap(int size) {
        this.container = new String[size];
    }

    public void put(String value) {
        int hash = getHash(value);
        if(container[hash].isBlank()) {
            container[hash] = value;
        } else {
            collisions.add(value);
        }
    }

    public void get(String value) {
        int hash = getHash(value);

    }

    private int getHash(String value) {
        int index = 0;
        // some formula
        for(char s : value.toCharArray()) {
            index += s + value.indexOf(s);
        }

        if(index > 0) {
            return index % container.length;
        } else {
            return index;
        }
    }
}
