package com.vosmann.practice.general;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import static java.lang.Integer.toBinaryString;

public class Shifts {

    public static void main(String[] args) {
        run(MIN_VALUE, 2);
        run(MAX_VALUE, 2);
        run(0, 2);
        run(1, 2);
        run(-1, 2);

        print(21);
        print(clearBitAndLeft(21, 2));
        print(clearBitAndRight(21, 2));
    }

    private static void run(int n, int i) {
        System.out.println(String.format("Number: %d (%s)", n, toBinary(n)));
        System.out.println(String.format("%d <<  %d = %d (%s)", n, i, n << i, toBinary(n << i)));
        System.out.println(String.format("%d >>  %d = %d (%s)", n, i, n >> i, toBinary(n >> i)));
        System.out.println(String.format("%d >>> %d = %d (%s)", n, i, n >>> i, toBinary(n >>> i)));
        System.out.println();
    }

    private static void print(int n) {
        System.out.println(String.format("%010d (%s)", n, toBinary(n)));
    }

    private static String toBinary(int n) {
        return String.format("%32s", toBinaryString(n)).replace(' ', '0');
    }

    private static boolean getBit(int n, int i) {
        return (n & (1 << i)) == 1;
    }

    private static int setBit(int n, int i) {
        return n | (1 << i);
    }

    private static int updateBit(int n, int i, boolean is1) {
        int mask = 1 << i;
        int restMask = ~mask;
        return (n & restMask) | (is1 ? mask : 0);
    }

    private static int clearBit(int n, int i) {
        int mask = ~(1 << i);
        return n & mask;
    }

    private static int clearBitAndRight(int n, int i) {
        // n: 1011101
        // m: 1110000
        // r: 1011000
        int m = (-1) << (i + 1);
        return n & m;
    }

    private static int clearBitAndLeft(int n, int i) {
        // n: 1011101
        // m: 0001111
        // r: 0001101
        int m = (-1) >>> (31 - i + 1);
        print(m);
        return n & m;
    }

}
