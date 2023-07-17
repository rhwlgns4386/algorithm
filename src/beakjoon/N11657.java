package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N11657 {
    static class Node{
        int node;
        int cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }

    static final long inf = 100000000;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine(), " ");
        int n=Integer.parseInt(stringTokenizer.nextToken());
        int m=Integer.parseInt(stringTokenizer.nextToken());

        long[] dist=new long[n+1];
        ArrayList<Node>[] a = new ArrayList[n + 1];

        for(int i=1;i<n+1;i++){
            a[i]=new ArrayList<>();
        }

        for(int i=1;i<=m;i++){
            stringTokenizer=new StringTokenizer(in.readLine());
            int start=Integer.parseInt(stringTokenizer.nextToken());
            int end=Integer.parseInt(stringTokenizer.nextToken());
            int w=Integer.parseInt(stringTokenizer.nextToken());
            a[start].add(new Node(end,w));
        }

        Arrays.fill(dist,inf);
        dist[1]=0;
        for(int i=0;i<n-1;i++){
            for(int j=1;j<n+1;j++){
                for(Node node:a[j]){
                    if(dist[j]!=inf){
                        dist[node.node]=Math.min(dist[node.node],dist[j]+node.cost);
                    }
                }
            }
        }

        for(int j=1;j<n+1;j++){
            for(Node node:a[j]){
                if(dist[j]!=inf&&dist[node.node]>dist[j]+node.cost){
                    System.out.println(-1);
                    System.exit(0);
                }
            }
        }

        for(int i=2;i<=n;i++){
            if(dist[i]!=inf){
                System.out.println(dist[i]);
            }else{
                System.out.println(-1);
            }
        }
    }
}
