package factory;

public class Runner {

    public static void main(String args []) {
        Base computerBase = BaseFactory.getBaseClass("Computer");
        Base laptopBase = BaseFactory.getBaseClass("");

        System.out.println(computerBase.getClass().toString());
        System.out.println(laptopBase.getClass().toString());
    }

}
