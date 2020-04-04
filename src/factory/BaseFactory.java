package factory;

public class BaseFactory {

    protected static Base getBaseClass(String component) {
        if(component.equalsIgnoreCase("Computer")) {
            return new ComputerBase();
        } else {
            return new LaptopBase();
        }
    }

}
