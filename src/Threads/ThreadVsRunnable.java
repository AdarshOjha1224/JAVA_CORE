package Threads;

// "extends Thread" or "implements Runnable" both have run() method so we can do any of them.

class FirstClass implements Runnable {
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


class SecondClass implements Runnable {
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

public class ThreadVsRunnable {
    public static void main(String[] args) {
        Runnable f1 = new FirstClass();
        Runnable s1 = new SecondClass();


        // In Thread class , constructor accept Runnable object
        Thread td1 = new Thread(f1);
        Thread td2 = new Thread(s1);

        td1.start();
        td2.start();
    }
}
