public final class MyImmutable {

    private final int myVal;

    public MyImmutable(int val) {
        myVal = val;
    }

    public final int getVal(){
        return myVal;
    }

    public final MyImmutable getInstance() throws CloneNotSupportedException {
        return (MyImmutable) this.clone();
    }

}

abstract class MyAbstract {

}
