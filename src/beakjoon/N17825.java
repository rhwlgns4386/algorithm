package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class N17825 {
    static Node[] graph=new Node[33];
    static int max=0;
    public static void main(String[] args) throws IOException {
        initGraph();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());

        int[] inputs=new int[10];
        for(int i=0;i<10;i++){
            inputs[i]=Integer.parseInt(stringTokenizer.nextToken());
        }
        go(inputs,new int[4],0,0);
        System.out.println(max);
    }

    private static void go(int[] inputs,int[] pieces,int idx, int sum) {
        if(idx==10){
            max=Math.max(max,sum);
            return;
        }

        for(int i=0;i<4;i++){

            int nextPosition=findNext(pieces[i],inputs[idx]);
            if(hasNext(nextPosition,pieces)) continue;

            int backup=pieces[i];
            pieces[i]=nextPosition;
            go(inputs,pieces,idx+1,sum+graph[nextPosition].marks);
            pieces[i]=backup;
        }
    }

    private static boolean hasNext(int nextPosition, int[] pieces) {
        for(int position:pieces){
            if(position==32) continue;
            if(nextPosition==position) return true;
        }
        return false;
    }

    private static int findNext(int start, int dist) {

        int next=start;
        for(int i=0;i<dist;i++){
            if(i==0 && graph[next].hasBlue()){
                next= graph[next].blue;
                continue;
            }

            next=graph[next].red;
        }

        return next;
    }

    private static void initGraph() {
        for(int i=0;i<=20;i++){
            Node node = new Node(i*2);
            node.red=i+1;
            graph[i]=node;
        }

        graph[20].red=32;
        graph[32]=new Node(0);
        graph[32].red=32;

        graph[5].blue=21;
        graph[21]=new Node(13,22);
        graph[22]=new Node(16,23);
        graph[23]=new Node(19,29);

        graph[10].blue=24;
        graph[24]=new Node(22,25);
        graph[25]=new Node(24,29);

        graph[15].blue=26;
        graph[26]=new Node(28,27);
        graph[27]=new Node(26,28);
        graph[28]=new Node(26,29);

        graph[29]=new Node(25,30);
        graph[30]=new Node(30,31);
        graph[31]=new Node(35,20);
    }

    private static class Node {
        public int marks;
        public int red=-1;
        public int blue=-1;

        public Node(int marks) {
            this.marks = marks;
        }

        public Node(int marks,int red){
            this.marks=marks;
            this.red=red;
        }

        public boolean hasBlue(){
            return blue!=-1;
        }
    }
}
