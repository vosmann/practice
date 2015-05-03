package com.vosmann.practice.ac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Rotation {

    private static final BufferedReader READER = getBufferedReader();
    private static final String DELIMITER = " ";

    public static void main(String[] args) throws IOException{
        String rotated = rotate(READER);
        System.out.println(rotated);
    }

    protected static String performRotationOnfile(String path) throws IOException {
        BufferedReader reader = getBufferedReader(path);
        return rotate(reader);
    }

    protected static String performRotationOnStdin() throws IOException {
        BufferedReader reader = getBufferedReader();
        return rotate(reader);
    }

    protected static String rotate(BufferedReader reader) throws IOException {

        int n = readIntegerFromLine(reader);
        String s = readLine(reader);

        int nrRotations = readIntegerFromLine(reader);
        List<RotationParam> params = new ArrayList<RotationParam>(nrRotations);
        for (int m = 0; m < nrRotations; ++m) {
            params.add(RotationParam.fromLine(readLine(reader)));
        }

        for (RotationParam param : params) {
            s = rotate(s, param);
            System.out.println("New S: " + s);
        }

        return s;
    }

    private static String rotate(String s, RotationParam param) {

        int safeRPlusOne =  getSafeRPlusOne(param.getR(), s.length());

        String prefix = s.substring(0, param.getL());
        String substring = s.substring(param.getL(), safeRPlusOne);
        String suffix = s.substring(safeRPlusOne, s.length());

        if (substring.length() <= 1) {
            return s;
        }

        System.out.println("prefix: " + prefix);
        System.out.println("substring: " + substring);
        System.out.println("suffix: " + suffix);

        int effectiveK = param.getK() < substring.length() ? param.getK() : param.getK() % substring.length();
        System.out.println("k: " + param.getK());
        System.out.println("k (eff.): " + effectiveK);
        if (effectiveK == 0) {
            return s;
        }

        StringBuilder rotatedSubstring = new StringBuilder();
        for (int index = substring.length() - effectiveK, nr = 0; nr < substring.length(); ++nr, index = (index + 1 >= substring.length()) ? 0 : index + 1) {
            char c = substring.charAt(index);
            System.out.println(String.format("index: %d, rotNr: %d, char: %c", index, nr, c));
            rotatedSubstring.append(c);
        }

        return new StringBuilder().append(prefix).append(rotatedSubstring).append(suffix).toString();
    }

    private static int getSafeRPlusOne(int r, int n) {
        return (r + 1 > n) ? n : r + 1;
    }

    private static int readIntegerFromLine(BufferedReader reader) throws IOException {
        String line = readLine(reader);
        int integer = Integer.valueOf(line);
        return integer;
    }

    private static String readLine(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        return line;
    }

    private static BufferedReader getBufferedReader(String filePath) {
        try {
            Path path = Paths.get(filePath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(path)));
            return reader;
        } catch (IOException e) {
            throw new RuntimeException("Problem while opening input file: " + e.getMessage());
        }
    }

    private static BufferedReader getBufferedReader() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader;
    }

    private static class RotationParam {
        private int l;
        private int r;
        private int k;
        public static RotationParam fromLine(String line) {
            String[] parts = line.split(DELIMITER);
            return new RotationParam( // They index starting at 1.
                    Integer.valueOf(parts[0]) - 1,
                    Integer.valueOf(parts[1]) - 1,
                    Integer.valueOf(parts[2]));
        }
        private RotationParam(int l, int r, int k) {
            this.l = l;
            this.r = r;
            this.k = k;
        }
        public int getL() {
            return l;
        }
        public int getR() {
            return r;
        }
        public int getK() {
            return k;
        }
    }

}
