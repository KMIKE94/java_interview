public class FactoryExample {

    public static void main(String args[]) {
         BaseFactory myFactory = MyFactory.getFactory("Test2");
         System.out.println(myFactory.getClass().toString());
    }

}

class MyFactory {

    public static BaseFactory getFactory(String name) {
        if(name.equals("Test1")) {
            return new Test1();
        } else {
            return new Test2();
        }
    }
}

interface BaseFactory { }

class Test1 implements BaseFactory {

}

class Test2 implements BaseFactory {

}
