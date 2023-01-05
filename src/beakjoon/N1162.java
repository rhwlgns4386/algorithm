package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class N1162 {
    static class Node implements Comparable<Node>{
        long cost;
        int vertex;
        int step;

        public Node(long cost, int vertex, int step) {
            this.cost = cost;
            this.vertex = vertex;
            this.step = step;
        }

        @Override
        public int compareTo(Node o) {
            if(this.cost<o.cost){
                return -1;
            }
            else if(this.cost==o.cost){
                return 0;
            }
            else return 1;
        }
    }

    static class Edge{
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static final long inf = 1000000000L*50000L;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(in.readLine(), " ");
        int n=Integer.parseInt(tokenizer.nextToken());
        int m=Integer.parseInt(tokenizer.nextToken());
        int k=Integer.parseInt(tokenizer.nextToken());

        ArrayList<Edge>[] a =(ArrayList<Edge>[]) new ArrayList[n + 1];
        for(int i=1;i<=n;i++){
            a[i]=new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            tokenizer=new StringTokenizer(in.readLine()," ");
            int from=Integer.parseInt(tokenizer.nextToken());
            int to=Integer.parseInt(tokenizer.nextToken());
            int cost=Integer.parseInt(tokenizer.nextToken());
            a[from].add(new Edge(to,cost));
            a[to].add(new Edge(from,cost));
        }

        long[][] dist=new long[n+1][k+1];
        boolean[][] visit=new boolean[n+1][k+1];

        for (int i=1; i<=n; i++) {
            for (int j=0; j<=k; j++) {
                dist[i][j] = inf;
            }
        }

        dist[1][0] = 0;
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(0,1,0));

        while (!q.isEmpty()){
            int v=q.peek().vertex;
            int step=q.peek().step;
            q.remove();

            if(visit[v][step]) continue;

            visit[v][step]=true;

            for (Edge edge : a[v]) {
                if(step+1<=k&&dist[edge.to][step+1]>dist[v][step]){
                    dist[edge.to][step+1]=dist[v][step];
                    q.add(new Node(dist[edge.to][step+1],edge.to,step+1));
                }
                if(dist[edge.to][step]>dist[v][step]+edge.cost){
                    dist[edge.to][step]=dist[v][step]+edge.cost;
                    q.add(new Node(dist[edge.to][step], edge.to, step));
                }
            }
        }

        long ans=inf;
        for (int i = 1; i <=k; i++) {
            if(visit[n][i]&&ans>dist[n][i]){
                ans=dist[n][i];
            }
        }
        System.out.println(ans);
    }
}
