import java.util.*;
import java.util.stream.Collectors;

public class Polymorphism {

    public static void main(String args[]) {
        B b = new C();
        System.out.println(3*0.1);

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("c");
        list.add("b");
        list.add("b");

        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("c");

        for(String listString: list) {
            System.out.print(listString + " ");
        }
        System.out.println("");
        set.forEach(con -> System.out.print(con + " "));

        int[] arr = {1,4,5,3,7,9,8,2};
        Arrays.stream(arr).sorted().forEach(val -> System.out.println(val));

    }

}

class A {

}

class B extends A {

}

class C extends B {

}
