package org.lyflexi.synchronize;

/**
 * @Author: ly
 * @Date: 2024/2/24 17:13
 */


/*请注意，wait()和notify()方法必须在synchronized块或synchronized方法中使用，否则将抛出IllegalMonitorStateException异常。*/
public class WaitAndNotify {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread incrementThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                counter.increment();
            }
        });

        Thread decrementThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                counter.decrement();
            }
        });

        incrementThread.start();
        decrementThread.start();
    }

    static public class Counter {
        private int count = 0;
        private final Object lock = new Object();

        public void increment() {
            synchronized (lock) {
                if (count == 10) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                count++;
                System.out.println("Count incremented. Current count: " + count);
                lock.notify();
            }
        }

        public void decrement() {
            synchronized (lock) {
                if (count == 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                count--;
                System.out.println("Count decremented. Current count: " + count);
                lock.notify();
            }
        }
    }
}



