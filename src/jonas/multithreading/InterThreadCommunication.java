package jonas.multithreading;

public class InterThreadCommunication {
    static Integer amount = 50;

    public static void main(String argsp[]) {
        Thread thread1 = new Thread() {
          @Override
          public void run() {
              // do some initial calc with amount
              // wait()
              // do final sum

              synchronized (amount) {
                  amount = amount - 5;
                  System.out.println("Withdraw 5 from account");

                  try{
                      wait();
                  } catch (InterruptedException ie) {
                      // do something
                  }

                  System.out.println("Final amount is " + amount);
              }
          }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                // acquire amount
                // add my special value to it
                // notify()

                synchronized (amount) {
                    amount -= 2;
                    System.out.println("Subtracting work fee: " + 2);
                    notify();
                }
            }
        };

        thread1.start();
        thread2.start();
    }
}
