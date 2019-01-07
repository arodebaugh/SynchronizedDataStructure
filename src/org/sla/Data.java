package org.sla;

public class Data {
    private Object[] dataList = new Object[100];
    private int x;
    private int numObjects;
    private int arrayCounter;
    private boolean queue;

    Data(boolean q, int n) {
        numObjects = n;
        queue = q;
        arrayCounter = -1;
        if (queue) {
            x = -1;
        } else {
            x = numObjects;
        }
    }

    synchronized boolean put(Object data) {
        arrayCounter++;
        try {
            dataList[arrayCounter] = data;
        } catch (ArrayIndexOutOfBoundsException exception) {
            return false;
        }
        return true;
    }

    synchronized boolean get() {
        if (queue) {
            x++;
        } else {
            x--;
        }

        try {
            System.out.println("Order Stack " + x + ": " + dataList[x]);
        } catch (ArrayIndexOutOfBoundsException exception) {
            return false;
        }

        if (x > numObjects) {
            System.out.println("ERROR: Data cannot output more than index of " + numObjects + ".");
            return false;
        } else if (x < 0) {
            System.out.println("ERROR: Data cannot output less than index of 0.");
            return false;
        } else if (x > dataList.length) {
            System.out.println("ERROR: Data cannot output more than index of size.");
            return false;
        }

        return true;
    }
}
