import java.util.*;
import java.util.stream.Collectors;

public class Practice {

    public static void main(String args[]) {
        int i = 6;
        System.out.println(isPrime(i));

        String actual = "abcd";

//        ModifyAbstract modifyAbstract = new ModifyAbstract();
//        modifyAbstract.printValue("Hey");

        ImplementInterface implementInterface = new ImplementInterface();
        implementInterface.printInterface();
        implementInterface.printSomthing();


        String containsNumber = "ab3n4";
        System.out.println(containsNumber.matches(regexForNumber()));

        List<String> stringList = new ArrayList<>();
        stringList.add("abc");
        stringList.add("das");
        stringList.add("sdavd");
        Collections.sort(stringList);

        String s1 = "abc";
        String s2 = "bcd";
        System.out.println(s1.compareTo(s2));

        Singleton mySingleton = Singleton.getInstance();

        removeDuplicatesAndSort();

        int[] arr = {2,3,1,4};
        bubblesort(arr);
        selectionsort(arr);
        insertionsort(arr);

        sortMyObject();
        outputPrimitiveDefaults();

        String im1 = "Welcome";
        String im2 = new String("Welcome");
        System.out.println(im1 == im2);

        try{
            Class c = Class.forName("MyObject");
            MyObject myObject = (MyObject)c.getDeclaredConstructor().newInstance();
        } catch(Exception ex) {
            // do something
        }

        int[] arr1 = {1,2,3,4};
        arr1.clone();

        byte myByte = Byte.valueOf("120");
        int myInt = myByte;
        System.out.println(myInt);

        Stack<String> stack = new Stack<>();
        stack.add("a");
        stack.add("b");
        stack.add("c");

        Queue<String> queue = new LinkedList<>();
        queue.add("a");
        queue.add("b");
        queue.add("c");

        ListIterator<String> stackListIterator = stack.listIterator();
        while(stackListIterator.hasNext()){
            System.out.print(stackListIterator.next() + " ");
        }
        System.out.println("");
        for(int x=0;x<=queue.size();x++){
            System.out.print(queue.poll() + " ");
        }

        isPalindrone("Navan");
        isPalindrone("NotPalin");

        int[] myArr = new int[5];
        System.out.println(myArr[2]);

        String string= "123";
        System.out.println(string.substring(0,1));
    }

    private static void isPalindrone(String input) {
        Stack<String> myStack = new Stack<>();
        for(int i=0;i<input.length();i++){
            myStack.add(String.valueOf(input.charAt(i)));
        }

        StringBuilder sb = new StringBuilder();
        while(!myStack.empty()){
            sb.append(myStack.pop());
        }
        System.out.println("Input: " + input);
        System.out.println("Output: " + sb.toString());
        System.out.println(sb.toString().equalsIgnoreCase(input));
    }

    private static void isParenthesisCorrect(char[] input) {
        if(input.length % 2 != 0) {
            System.out.println("False");
        }

        Stack<Character> myStack = new Stack<>();
        for(int i=0;i<input.length;i++){

            myStack.add(input[i]);
        }
    }

    private static void outputPrimitiveDefaults() {
        MyObject myObject = new MyObject();

        System.out.println(myObject.getIntVal());
        System.out.println(myObject.getStrVal());
        System.out.println(myObject.getC());
        System.out.println(myObject.getB());
    }

    private static void sortMyObject() {
        MyObjectComparator myObjectComparator = new MyObjectComparator();
        Set<MyObject> myObjectSet = new TreeSet<MyObject>(new MyObjectComparator());
        
    }

    private static boolean isPrime(int i) {
        // mod 1 is 1
        // mod
        for(int x=2; x < i; x++){
            if(i%x==0){
                return false;
            }
        }

        return true;
    }

    private static void removeDuplicatesAndSort() {
        int[] arr = {3,4,2,1,7,7,7,8,6,5,5,4,3,2,1,2,3};
        System.out.println("*********\nPrinting Array Unsorted");
        //print arr
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();


        Set<Integer> noDupesAndSorted = new TreeSet<>();
        for(int i=0;i<arr.length;i++){
            noDupesAndSorted.add(arr[i]);
        }

        noDupesAndSorted.forEach(val -> System.out.print(val + " "));
    }

    private static void bubblesort(int arr[]) {
        for(int i=0;i<arr.length-1;i++) {
            for(int j=i+1;j<arr.length;j++){
                if(arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
        printArray(arr);
    }

    private static void selectionsort(int arr[]) {
        for(int i=0;i<arr.length-1;i++){
            int biggest = arr[i];
            int index = i;
            for(int j=i+1;j<arr.length;j++){
                if(biggest > arr[j]) {
                    biggest = arr[j];
                    index = j;
                }
            }
            if(i != index)
                swap(arr, index, i);
        }
        printArray(arr);

    }

    private static void insertionsort(int arr[]){
        int inner;
        for(int outer=1;outer<arr.length;outer++){
            inner=outer;
            int temp = arr[outer];
            while(inner > 0 && arr[inner-1] > temp) {
                arr[inner] = arr[inner-1];
                inner--;
                if(inner==0)
                    break;
            }
            arr[inner] = temp;
        }
        printArray(arr);

    }

    private static final void printArray(int arr[]) {
        System.out.println();
        for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static final void swap(int[] arr, int a, int b) {
        int swap = arr[a];
        arr[a] = arr[b];
        arr[b] = swap;
    }

    private static String regexForNumber() {
        return "[a-zA-Z]*[0-9]+[a-zA-Z]*";
    }


}






interface TestInterface {
    String s = "This";

    default void printSomthing() {
        System.out.println("Something");
    }
}

abstract class TestAbstract {
}

//class ModifyAbstract extends TestAbstract {
//
//    @Override
//    void printMyVal(String a) {
//
//    }
//}

class ImplementInterface implements TestInterface {
    public void printInterface() {
        System.out.println(this.s);
    }
}




final class Singleton {
    private static volatile Singleton _INSTANCE = null;

    public static Singleton getInstance() {
        if(_INSTANCE == null) {
            synchronized (Singleton.class) {
                if(_INSTANCE == null) {
                    _INSTANCE = new Singleton();
                    return _INSTANCE;
                }
            }
        }
        return _INSTANCE;
    }
}

abstract class TestingAbstract {
    String s = "";
    public void doSomthing(){}

    private void doSomthing2() {

    }

    public void doSomething3() {}
}

class Abstract extends TestingAbstract {
    public Abstract() {
        s = "123";
    }
}

class PrivateBoy {
    private PrivateBoy() {

    }
}

class CompareObject implements Comparable<String> {
    public int compareTo(String t) {

        return 0;
    }
}

