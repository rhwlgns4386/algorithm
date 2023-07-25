package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1991 {

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
}

class Tree{
    private char[] a;
    private int[] alphabetIdx=new int[26];
    private char NULL='\u0000';

    public Tree(char[][] nodes,int n) {
        a=new char[2<<n];
        a[1]='A';
        alphabetIdx[0]=1;
        build(nodes,0);
    }

    private void build(char[][] nodes, int deeps) {
        if(deeps==nodes.length) return;
        Character root = nodes[deeps][0];
        int p=alphabetIdx[findIndex(root)];

        if(!(nodes[deeps][1]=='.')){
            int left = left(p);
            alphabetIdx[findIndex(nodes[deeps][1])]=left;
            a[left]=nodes[deeps][1];
        }
        if(!(nodes[deeps][2]=='.')){
            int right = right(p);
            alphabetIdx[findIndex(nodes[deeps][2])]=right;
            a[right]=nodes[deeps][2];
        }

        build(nodes,deeps+1);
    }

    public String preorderTraversal(){
        StringBuilder stringBuilder = new StringBuilder();
        preorderTraversal(1,stringBuilder);
        return stringBuilder.toString();
    }

    public String inorderTraversal(){
        StringBuilder stringBuilder = new StringBuilder();
        inorderTraversal(1,stringBuilder);
        return stringBuilder.toString();
    }
    public String postorderTraversal(){
        StringBuilder stringBuilder = new StringBuilder();
        postorderTraversal(1,stringBuilder);
        return stringBuilder.toString();
    }

    private void preorderTraversal(int p,StringBuilder stringBuilder){
        if(p>=a.length)return;
        if(a[p]==NULL) return;
        stringBuilder.append(a[p]);
        preorderTraversal(left(p),stringBuilder);
        preorderTraversal(right(p),stringBuilder);
    }
    private void inorderTraversal(int p,StringBuilder stringBuilder){
        if(p>=a.length)return ;
        if(a[p]==NULL) return ;
        inorderTraversal(left(p),stringBuilder);
        stringBuilder.append(a[p]);
        inorderTraversal(right(p),stringBuilder);
    }

    private void postorderTraversal(int p,StringBuilder stringBuilder){
        if(p>=a.length)return ;
        if(a[p]==NULL) return ;

        postorderTraversal(left(p),stringBuilder);
        postorderTraversal(right(p),stringBuilder);
        stringBuilder.append(a[p]);
    }
    private int right(int p) {
        return (p<<1)+1;
    }

    private int left(int p) {
        return p<<1;
    }

    private int findIndex(Character alphabet) {
        return alphabet-'A';
    }
}
