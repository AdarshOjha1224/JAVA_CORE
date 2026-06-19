package Threads;

// Thread shouldn't be mutable.
// example - One account of balance 10000 has two cards. both cards withdraw 7000 at a same time. Which is like mutability two thread are changing a value at same time.

class Counter {
    int count ;
    // synchronized keyword - make sure that increment() will run by one thread at a time.
    public synchronized void increment(){
        count++;
    }
}


public class RaceCondition {
    // Main Thread
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        Runnable r1 = () -> {
            for(int i = 1 ; i <= 10000 ; i++){
                c.increment();
            }
        };
        Runnable r2 = () -> {
            for(int i = 1 ; i <= 10000 ; i++){
                c.increment();
            }
        };

        // we create two threads t1 and t2
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

        // Tell the Main thread to WAIT for t1 and t2 to finish their work
        t1.join();
        t2.join();

        // main print count which is not 2000 *everything even after join because
        // Both threads are working on same variable , so the both threads run simultaneously and get same increment value , that's why it is less than 2000.
        //
        System.out.println(c.count);
    }
}
