package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class N1991_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());

        char[][] nodes = new char[n][3];
        for(int i=0;i<n;i++){
            char[] chars = in.readLine().replace(" ","").toCharArray();
            for(int j=0;j<3;j++){
                nodes[i][j]=chars[j];
            }
        }

        Tree tree = new Tree(nodes,n);

        System.out.println(tree.preorderTraversal());
        System.out.println(tree.inorderTraversal());
        System.out.println(tree.postorderTraversal());
    }

    static class Tree{
        private HashMap<Character,Pair> map;
        private final char EMPTY ='.';

        public Tree(char[][] nodes,int n) {
            map =new HashMap<>();
            build(nodes,0);
        }

        private void build(char[][] nodes, int deeps) {
            if(deeps==nodes.length) return;

            Character root = nodes[deeps][0];
            map.put(root,new Pair(nodes[deeps][1],nodes[deeps][2]));

            build(nodes,deeps+1);
        }

        public String preorderTraversal(){
            StringBuilder stringBuilder = new StringBuilder();
            preorderTraversal('A',stringBuilder);
            return stringBuilder.toString();
        }

        public String inorderTraversal(){
            StringBuilder stringBuilder = new StringBuilder();
            inorderTraversal('A',stringBuilder);
            return stringBuilder.toString();
        }
        public String postorderTraversal(){
            StringBuilder stringBuilder = new StringBuilder();
            postorderTraversal('A',stringBuilder);
            return stringBuilder.toString();
        }

        private void preorderTraversal(char key,StringBuilder stringBuilder){
            if (key== EMPTY) return;
            Pair pair = map.get(key);
            stringBuilder.append(key);
            preorderTraversal(pair.getLeft(),stringBuilder);
            preorderTraversal(pair.getRight(),stringBuilder);
        }
        private void inorderTraversal(char key,StringBuilder stringBuilder){
            if (key==EMPTY) return;
            Pair pair = map.get(key);
            inorderTraversal(pair.getLeft(),stringBuilder);
            stringBuilder.append(key);
            inorderTraversal(pair.getRight(),stringBuilder);
        }

        private void postorderTraversal(char key,StringBuilder stringBuilder){
            if (key== EMPTY) return;
            Pair pair = map.get(key);
            postorderTraversal(pair.getLeft(),stringBuilder);
            postorderTraversal(pair.getRight(),stringBuilder);
            stringBuilder.append(key);
        }
    }

    static class Pair{
        private char left;
        private char right;

        public Pair(char left, char right) {
            this.left = left;
            this.right = right;
        }

        public char getLeft() {
            return left;
        }

        public char getRight() {
            return right;
        }
    }
}
