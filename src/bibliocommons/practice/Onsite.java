package bibliocommons.practice;

public class Onsite {
    public static void main(String argsp[]) {
        Animal dog = new Dog();
        Animal cat = new Cat();

        dog.breath();
        cat.breath();
    }
}

abstract class Animal {
    abstract void breath();

    final void walk() {
        System.out.println("Walks on all 4's");
    }
}

class Dog extends Animal {
    @Override
    void breath() {
        System.out.println("Dog breaths");
    }
}

class Cat extends Animal {
    @Override
    void breath() {
        System.out.println("Cat breaths");
    }

}
