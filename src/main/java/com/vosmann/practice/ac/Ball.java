package com.vosmann.practice.ac;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ball {

    private static final Scanner READER = getScanner();
    private static int[] BALLS;

    public static void main(String[] args) throws IOException{
        String afterAllSets = performSets(READER);
        System.out.println(afterAllSets);
    }

    protected static String performSetOnFile(String path) throws IOException {
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        return performSets(scanner);
    }

    protected static String performSets(Scanner scanner) throws IOException {

        generateFreshBalls();

        int n = scanner.nextInt();
        int k = scanner.nextInt();

        List<Op> ops = new ArrayList<Op>(n);
        for (int i = 0; i < n; ++i) {
            ops.add(new Op(scanner.nextInt(), scanner.nextInt()));
        }

        // reduce doing all ops to a single transformation
        // int[] afterOps = performSingleSet(); // compare with original

        // brute force
        for (int i = 0; i < k; ++i) {
            for (Op op : ops) {
                doOp(op);
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(BALLS[0]);
        for (int i = 1; i < BALLS.length; ++i) {
            result.append(" ").append(BALLS[i]);
        }
        return result.toString();
    }

    private static void doOp(Op op) {
        int left = BALLS[op.getLeft()];
        int right = BALLS[op.getRight()];
        BALLS[op.getLeft()] = right;
        BALLS[op.getRight()] = left;
    }

    static int[] performSingleSet() {
        return null;
    }

    private static Scanner getScanner() {
        try {
            return new Scanner(System.in);
        } catch (Exception e) {
            throw new RuntimeException("input problem");
        }
    }

    private static class Op {
        private int left;
        private int right;
        public Op(int left, int right) {
            this.left = left - 1;
            this.right = right - 1;
        }
        public int getLeft() {
            return left;
        }
        public int getRight() {
            return right;
        }
    }

    private static void generateFreshBalls() {
        BALLS = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
    }

}
