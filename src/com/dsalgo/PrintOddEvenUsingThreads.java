package com.dsalgo;

public class PrintOddEvenUsingThreads {

    int count = 1;
    static int N;

    public static void main(String[] args) {
        N = 10;

        // Create an object of class
        PrintOddEvenUsingThreads mt = new PrintOddEvenUsingThreads();

        // Create thread t1
        Thread t1 = new Thread(mt::printEven);

        // Create thread t2
        Thread t2 = new Thread(mt::printOdd);

        // Start both threads
        t1.start();
        t2.start();

    }

    public void printOdd() {
        synchronized (this) {
            while (count < N) {
                while (count % 2 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {

                    }
                }
                System.out.println(count);
                count++;
                notify();
            }
        }

    }

    public void printEven() {
        synchronized (this) {
            while (count < N) {
                while (count % 2 == 1) {
                    try {
                        wait();
                    } catch (InterruptedException e) {

                    }
                }
                System.out.println(count);
                count++;
                notify();
            }
        }

    }
}
