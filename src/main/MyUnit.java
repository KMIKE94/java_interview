package main;

public class MyUnit {

    public int getInteger(int i) {
        if(i == 0) {
            throw new NumberFormatException("Number cannot be Zero (0)");
        } else {
            return i/2;
        }
    }
}
