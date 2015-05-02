package com.vosmann.practice.e;


import java.util.ArrayList;
import java.util.List;

public class Pe0002Version01 {

    public static void main(String[] argv)  {
        List<Long> fibonacci = new ArrayList<Long>();
        fibonacci.add(1L);
        fibonacci.add(2L);
        long sumA = 2;
        long sumB = 2;

        int i = 2;

        long term;

        do {
            term = fibonacci.get(i-1) + fibonacci.get(i-2);
            fibonacci.add(term);
            if ((i-1) % 3 == 0) {

                sumA += term;
                System.out.println("A got the term: " + term + " , i=" + i);
                System.out.println("sumA: " + sumA);
            }
            if ((term % 2) == 0) {
                sumB += term;
                System.out.println("B got the term: " + term + " , i=" + i);
                System.out.println("sumB: " + sumB);
            }
            ++i;
        } while (term <= 4000000);

        System.out.println("sumA: " + sumA);
        System.out.println("sumB: " + sumB);
    }
}
