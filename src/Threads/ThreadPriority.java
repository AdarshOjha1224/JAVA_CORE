package Threads;

// "extends Thread" or "implements Runnable" both have run() method so we can do any of them.
class First extends Thread {
    public void run(){
        for(int i = 1 ; i <= 10 ; i++){
            System.out.println("First");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class Second extends Thread {
    public void run(){
        for(int i = 1 ; i <= 10 ; i++){
            System.out.println("Second");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


public class ThreadPriority {
    public static void main(String[] args) {


        // WHEN WE USE THE "EXTENDS THREADS" INSTEAD OF "IMPLEMENTS RUNNABLE"
        First f1 = new First();
        Second s1 = new Second();

        // The range of priority is 1 to 10.
        // Default is 5
        System.out.println(s1.getPriority()); // 5

        // This just suggest that s1 should get priority.
        s1.setPriority(Thread.MAX_PRIORITY);

        // sleep is waiting stage

        f1.start();
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        s1.start();

    }
}