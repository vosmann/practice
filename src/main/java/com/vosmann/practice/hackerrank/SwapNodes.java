package com.vosmann.practice.hackerrank;

import com.google.common.collect.Lists;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Not pretty. Just getting started with this "everything-in-one-solution-class" format.
 */
public class SwapNodes {

    private static final BufferedReader READER = getBufferedReader();
    private static final String DELIMITER = " ";
    private static final int NULL_NODE_INDEX = -1;

    public static void main(String[] args) throws IOException{
        List<String> swapResults = swap(READER);
        for (String swapResult : swapResults) {
            System.out.println(swapResult);
        }
    }

    protected static List<String> swapFromFile(String path) throws IOException {
        BufferedReader fileReader = getBufferedReader(path);
        return swap(fileReader);
    }

    protected static List<String> swap(BufferedReader reader) throws IOException {

        int nrNodes = readIntegerFromLine(reader); // N
        System.out.println("nrNodes: " + nrNodes);
        List<Node> nodes = new ArrayList<Node>(nrNodes + 1); // 0th position is empty, unused.
        nodes.add(0, null); // Beautiful.

        for (int index = 1; index <= nrNodes; ++index) {
            Node node = Node.fromLine(index, readLine(reader));
            nodes.add(node);
        }
        System.out.println("Initial tree (in-order traversal):");
        System.out.println(getInOrderTraversal(nodes));

        int nrOps = readIntegerFromLine(reader); // T
        System.out.println("nr swap operations: " + nrOps);
        List<Integer> ks = new ArrayList<Integer>(nrOps); // all K's, i.e. basic depths
        for (int opNr = 0; opNr < nrOps; ++opNr) {
            ks.add(readIntegerFromLine(reader));
        }

        List<String> swapResults = Lists.newArrayList();
        for (int k : ks) { swapAt(k, 1, 1, nodes);
            String swapResult = getInOrderTraversal(nodes);
            System.out.println("After k: " + k);
            System.out.println(swapResult);
            swapResults.add(swapResult);
        }
        return swapResults;
    }

    private static void swapAt(int k, int index, int depth, List<Node> nodes) {
        if (index == NULL_NODE_INDEX) {
            return;
        }

        Node node = nodes.get(index);
        int left = node.getLeft();
        int right = node.getRight();

        if (depth % k == 0) {
            node.setRight(left);
            node.setLeft(right);
        }

        swapAt(k, left, depth + 1, nodes);
        swapAt(k, right, depth + 1, nodes);
    }

    private static String getInOrderTraversal(List<Node> nodes) {
        StringBuilder builder = new StringBuilder();
        appendInOrderTraversal(1, nodes, builder);
        return builder.toString().trim();
    }

    private static void appendInOrderTraversal(int index, List<Node> nodes, StringBuilder builder) {
        if (index == NULL_NODE_INDEX) {
            return;
        }

        Node node = nodes.get(index);
        appendInOrderTraversal(node.getLeft(), nodes, builder);
        builder.append(node.getIndex()).append(DELIMITER);
        appendInOrderTraversal(node.getRight(), nodes, builder);
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

    private static class Node {

        private int left;
        private int right;
        private int index;

        private Node(int index, int left, int right) {
            this.index = index;
            this.left = left;
            this.right = right;
        }

        public static Node fromLine(int index, String line) {
            return readNodeFromLine(index, line);
        }

        public int getLeft() {
            return left;
        }

        public int getRight() {
            return right;
        }

        public int getIndex() {
            return index;
        }

        public void setLeft(int left) {
            this.left = left;
        }

        public void setRight(int right) {
            this.right = right;
        }

        private static Node readNodeFromLine(int index, String line) {
            String[] parts = line.split(DELIMITER);
            return new Node(index, Integer.valueOf(parts[0]), Integer.valueOf(parts[1]));
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Node{");
            sb.append("left=").append(left);
            sb.append(", right=").append(right);
            sb.append(", index=").append(index);
            sb.append('}');
            return sb.toString();
        }
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


}
