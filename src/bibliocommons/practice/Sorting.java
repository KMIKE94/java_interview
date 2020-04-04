package bibliocommons.practice;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sorting {
    public static void main(String argsp[]){
        Sorting sort = new Sorting();
        sort.readPropertiesFile();

        sort.readUserInput();
        sort.readUserInputBufferedReader();
    }

    void readUserInputBufferedReader(){
        BufferedReader bir;
        bir = new BufferedReader(new InputStreamReader(System.in));

        try (bir) {

        } catch (IOException ioe){

        }
    }

    void readUserInput() {
        Scanner in = new Scanner(System.in);
        int data = in.nextInt();
        StringBuffer sb = new StringBuffer();
        while(data > 0) {
            sb.append(in.nextLine());
            data--;
        }

        System.out.println(sb.toString());
    }

    void readPropertiesFile() {
        Properties props = new Properties();
        try(FileReader fr = new FileReader(new File(this.getClass().getResource("contents.properties").getPath()))) {

            props.load(fr);
            Map<String, String> map = new HashMap<>();
            props.forEach((k,v) -> map.put(String.valueOf(k),String.valueOf(v)));

            for(Map.Entry<String,String> entries: map.entrySet()) {
                System.out.println("Key: " + entries.getKey() + " Value: " + entries.getValue());
            }

        } catch(FileNotFoundException fex) {
            System.out.println("File not found exception");
        } catch(IOException ioe) {
            System.out.println("IO exception");
        }
    }

    void readAndPrintFile() {
        try(BufferedReader br = new BufferedReader(new FileReader(new File(this.getClass().getResource("contents.txt").getPath())))) {
            List<String> contents = br.lines().collect(Collectors.toList());
            contents.forEach(System.out::println);
        } catch (FileNotFoundException ex) {
            // do something
            System.out.println("FileNotFoundException: " + ex.getMessage());
        } catch(Exception ex) {
            // do something
            System.out.println("Exception: " + ex.getMessage());
        }
    }

    static String isValid(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            if(map.isEmpty()) {
                map.put(c, 1);
            } else {
                if(map.containsKey(c)){
                    int val = map.get(c);
                    map.put(c, val+1);
                }else {
                    map.put(c,1);
                }

            }
        }

        List<Integer> list = new ArrayList<>();
        map.forEach((k,v) -> list.add(v));
        Collections.sort(list);

        int lowest = list.get(0);
        if(lowest == list.get(list.size()-1) || lowest+1 == list.get(list.size()-1)) {
            return "YES";
        } else {
            return "NO";
        }
    }

    static int alternativeCharacter(String s1) {
        int counter = 0;
        for(int i=1;i<s1.length();i++){
            // AA
            if(s1.charAt(i-1) == s1.charAt(i)){
                counter++;
            }
        }


        return counter;
    }

    static int makeAnagram(String a, String b) {
        String[] aarr = a.split("");
        String[] barr = b.split("");
        LinkedList<String> alist = new LinkedList<>(Arrays.asList((aarr)));
        LinkedList<String> blist = new LinkedList<>(Arrays.asList(barr));
        Collections.sort(alist);
        Collections.sort(blist);
        int counter = 0;
        for(String letter : alist) {
            if(blist.contains(letter)){
                counter++;
                blist.removeFirstOccurrence(letter);
            }
        }
            return alist.size() + blist.size() - counter;
    }

    static void quicksortAlg(int[] arr) {
        quicksort(arr, 0, arr.length-1);
    }

    static void quicksort(int[] arr, int low, int high) {
        if(low < high){
            int pi = partition(arr, low, high);
            quicksort(arr, low, pi-1);
            quicksort(arr,pi+1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low-1);
        for(int j = low; j <= high; j++) {
            if(arr[j] < pivot) {
                i++;
                int swap = arr[i];
                arr[i] = arr[j];
                arr[j] = swap;
            }
        }

        int swap = arr[i+1];
        arr[i+1] = arr[high];
        return i+1;

    }
}

