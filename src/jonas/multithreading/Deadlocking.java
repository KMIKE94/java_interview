package jonas.multithreading;

public class Deadlocking {

    /*
    Deadlocking is when one thread wants to access the resources not
    released yet by another thread
     */
    public static void main(String argsp[]) {
        final String s1 = "MyString";
        final String s2 = "MyOtherString";

        Thread thread1 = new Thread(){
          @Override
          public void run() {
              synchronized (s1) {
                  System.out.println("Thread 1 locking " + s1);


                  try {
                      s1.wait();
                  } catch (InterruptedException i) {
                  }

                  synchronized (s2) {
                      System.out.println("Thread 1 locking " + s2);
                  }
              }
          }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                synchronized (s2) {
                    System.out.println("Thread 2 locking " + s2);


                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException i) {
                    }

                    synchronized (s1) {
                        System.out.println("Thread 2 locking " + s1);
                        s1.notify();
                    }
                    s2.notify();
                }
            }

        };

        thread1.start();
        thread2.start();

    }

}
