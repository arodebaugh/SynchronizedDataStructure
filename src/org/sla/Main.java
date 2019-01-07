package org.sla;

public class Main {

    public static void main(String[] args) {
        // 100 total objects

        int numObjects1 = 100;

        Data data1 = new Data(false, numObjects1);

        Put put1 = new Put(data1, numObjects1, 0);
        Get get1 = new Get(data1, numObjects1, 0);

        Thread putThread1 = new Thread(put1);
        putThread1.start();

        Thread getThread1 = new Thread(get1);
        getThread1.start();

        // 300 total objects

        int numObjects2 = 300;

        Data data2 = new Data(false, numObjects2);

        Put put2 = new Put(data2, numObjects2, 1);
        Get get2 = new Get(data2, numObjects2, 1);

        Thread putThread2 = new Thread(put2);
        putThread2.start();

        Thread getThread2 = new Thread(get2);
        getThread2.start();
    }
}
