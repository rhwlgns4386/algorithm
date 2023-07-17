package beakjoon;

import java.util.HashMap;

public class Trie {

    static class Node {
        HashMap<Character,Node> chile=new HashMap<>();
        boolean lastNode;
    }

    static class RootNode{
        Node rootNode=new Node();
    }
    public static void main(String[] args) {

    }
}
