package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N1753  {
    static class Edge implements Comparable<Edge>{
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge that) {
            if (this.cost < that.cost) {
                return -1;
            } else if (this.cost == that.cost) {
                if (this.to < that.to) return -1;
                else if (this.to > that.to) return 1;
                else return 0;
            } else {
                return 1;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(in.readLine(), " ");
        int n=Integer.parseInt(tokenizer.nextToken());
        int e=Integer.parseInt(tokenizer.nextToken());

        boolean[] visit=new boolean[n+1];
        int[] dist=new int[n+1];
        ArrayList<Edge>[] a = new ArrayList[n + 1];
        PriorityQueue<Edge> q = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            a[i]=new ArrayList<>();
            dist[i]=Integer.MAX_VALUE;
        }

        int start=Integer.parseInt(in.readLine());
        for (int i = 0; i < e; i++) {
            tokenizer=new StringTokenizer(in.readLine()," ");
            int u=Integer.parseInt(tokenizer.nextToken());
            int v=Integer.parseInt(tokenizer.nextToken());
            int w=Integer.parseInt(tokenizer.nextToken());

            a[u].add(new Edge(v,w));
        }

        dist[start]=0;
        q.add(new Edge(start,dist[start]));

        while (!q.isEmpty()){
            Edge edge = q.remove();
            if(visit[edge.to]){
                continue;
            }
            visit[edge.to]=true;
            for (Edge edge1 : a[edge.to]) {
                if(dist[edge1.to]>dist[edge.to]+edge1.cost){
                    dist[edge1.to]=dist[edge.to]+edge1.cost;
                    q.add(new Edge(edge1.to,dist[edge1.to]));
                }
            }
        }
        for (int i=1; i<=n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }
}
