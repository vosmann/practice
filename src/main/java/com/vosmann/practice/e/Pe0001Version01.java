package com.vosmann.practice.e;


public class Pe0001Version01 {

    public static void main(String[] argv)  {
        int sum = 0;
        for (int i = 0; i < 1000; ++i) {
            if ((i % 3 == 0) || (i % 5 == 0)) {
                System.out.println("Adding: " + i);
                sum += i;
            }
        }

        System.out.println("Sum: " + sum);
    }
}
