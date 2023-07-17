package beakjoon;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Comparator;
//import java.util.PriorityQueue;
//
//public class N1436 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        Comparator.reverseOrder()
//        int k=Integer.parseInt(in.readLine());
//        int cnt=0;
//        for(int i=666;i<=10000000;i++){
//            if(Integer.toString(i).contains("666")){
//                cnt++;
//            }
//            if(cnt==k){
//                System.out.println(i);
//                break;
//            }
//        }
//    }
//}

import java.io.*;
import java.util.*;

public class N1436{
    static class Node{
        int node;
        int weight;
        public Node(int node,int weight){
            this.node=node;
            this.weight=weight;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int V=Integer.parseInt(in.readLine());

        ArrayList<ArrayList<Node>> a=new ArrayList<>();
        for(int i=0;i<V;i++){
            a.add(new ArrayList<>());
        }


        for(int i=0;i<V;i++){
            StringTokenizer st=new StringTokenizer(in.readLine());
            int start=Integer.parseInt(st.nextToken())-1;

            while(st.hasMoreTokens()){
                int node=Integer.parseInt(st.nextToken())-1;

                if(node==-2) break;
                int weight=Integer.parseInt(st.nextToken());

                a.get(start).add(new Node(node,weight));
            }
        }

        boolean[] visit=new boolean[V];
        dfs(a,visit,0);
        System.out.println();

    }

    public static long dfs(ArrayList<ArrayList<Node>> a, boolean[] visit,int next){
        long max=0;
        visit[next]=true;

        for(Node n:a.get(next)){
            int node=n.node;
            int weight=n.weight;
            if(!visit[node]){
                max=Math.max(max,dfs(a,visit,node)+weight);
            }
        }

        return max;
    }
}
