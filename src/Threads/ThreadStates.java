package Threads;

public class ThreadStates {
    // When we create a thread then it goes through these state.
    // States - New , Runnable , Running , Waiting , Dead.
    // Transitions -----

    // New -> Start() -> Runnable
    // Runnable -> run() -> Running
    // Running -> sleep()/wait() -> Waiting
    // Waiting -> notify() -> Runnable
    // Running -> stop() -> Dead
    // Runnable -> Stop() -> Dead

    public static void main(String[] args) {
        // Create the thread (State: NEW)
        Thread myThread = new Thread(() -> {
            try {
                // Thread is now executing (Conceptual State: RUNNING)
                System.out.println("   [Thread] Executing run() method...");

                // Induce a delay to push it into a waiting state
                // (Conceptual State: WAITING / Java State: TIMED_WAITING)
                Thread.sleep(1500);

                System.out.println("   [Thread] Woke up, finishing execution...");
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted.");
            }
        });

        try {
            // 1. NEW
            System.out.println("1. State immediately after creation: " + myThread.getState() + " (Conceptual: New)");

            // 2. RUNNABLE
            myThread.start();
            System.out.println("2. State after calling start(): " + myThread.getState() + " (Conceptual: Runnable)");

            // We pause the main thread briefly to let 'myThread' actually start executing
            Thread.sleep(200);

            // 3. WAITING (Timed Waiting)
            // myThread is currently sleeping inside its run() method
            System.out.println("3. State while thread is sleeping: " + myThread.getState() + " (Conceptual: Waiting)");

            // 4. DEAD (Terminated)
            // join() tells the main thread to wait until 'myThread' finishes completely
            myThread.join();
            System.out.println("4. State after thread finishes execution: " + myThread.getState() + " (Conceptual: Dead)");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
