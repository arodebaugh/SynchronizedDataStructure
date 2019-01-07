package org.sla;

public class Put implements Runnable {
    private Data data;
    private int numObjects;
    private int id;

    Put(Data d, int n, int i) {
        data = d;
        numObjects = n;
        id = i;
    }

    @Override
    public void run() {
        for (int x = 1; x <= numObjects; x++) {
            boolean dataSuccesful = data.put(x);
            while (!dataSuccesful) {
                // let other threads make some progress; hopefully another thread will decrement below 100
                Thread.currentThread().yield();
                // try incrementing again
                dataSuccesful = data.put(x);
            }
        }
    }
}
