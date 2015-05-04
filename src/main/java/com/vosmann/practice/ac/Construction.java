package com.vosmann.practice.ac;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Construction {

    private static final Scanner SCANNER = getScanner();
    private static final int EMPTY = -1;
    private static final int[][] NETWORK;

    public static void main(String[] args) throws IOException{
        String result = run(SCANNER);
        System.out.println(result);
    }

    protected static String runOnFileInput(String path) throws IOException {
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        return run(scanner);
    }

    protected static String run(Scanner scanner) throws IOException {

        int n = scanner.nextInt();
        int q = scanner.nextInt();

        int[][] network = generateEmptyIslandNetwork(n);
        StringBuilder result = new StringBuilder();

        for (int date = 0; date < q; ++date) {

            String query = scanner.nextLine();

            if (query.startsWith("build ")) {
                IslandPair pair = IslandPair.fromQuery(query);
                build(pair, date);
            } else if (query.startsWith("check ")) {
                IslandPair pair = IslandPair.fromQuery(query);
                result.append(check(pair));
            } else {
                throw new RuntimeException("Invalid query.");
            }
            result.append(System.lineSeparator());
        }

        return result.toString();
    }

    private static void build(IslandPair pair, int date) {
        NETWORK[pair.a][pair.b] = date;
    }

    private static String check(IslandPair pair) {
        return "";
    }

    private static int[][] generateEmptyIslandNetwork(int n) {
        int[][] network = new int[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                network[i][j] = EMPTY;
            }
        }
        return network;
    }

    private static Scanner getScanner() {
        try {
            return new Scanner(System.in);
        } catch (Exception e) {
            throw new RuntimeException("input problem");
        }
    }

    private static class IslandPair {
        int a;
        int b;
        public static IslandPair fromQuery(String query) {
            String islands = query.substring(6);
            String [] islandParts = islands.split(" ");
            return new IslandPair(Integer.valueOf(islandParts[0]), Integer.valueOf(islandParts[1]));
        }
        private IslandPair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
