package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N11657 {
    static class Edge{
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static final long inf = 100000000;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine(), " ");
        int n=Integer.parseInt(stringTokenizer.nextToken());
        int m=Integer.parseInt(stringTokenizer.nextToken());

        ArrayList<Edge> edges = new ArrayList<>();
        long[] dist=new long[n+1];

        for (int i=1; i<=n; i++) {
            dist[i] = inf;
        }

        for(int i=0;i<m;i++){
            stringTokenizer=new StringTokenizer(in.readLine()," ");
            int from=Integer.parseInt(stringTokenizer.nextToken());
            int to=Integer.parseInt(stringTokenizer.nextToken());
            int cost=Integer.parseInt(stringTokenizer.nextToken());
            edges.add(new Edge(from,to,cost));
        }

        boolean cycle=false;
        dist[1]=0;
        for (int i = 1; i <= n; i++) {
            for (Edge edge : edges) {
                int from = edge.from;
                int to = edge.to;
                int cost = edge.cost;

                if(dist[from]!=inf && dist[to]>dist[from]+cost){
                    dist[to]=dist[from]+cost;
                    if(i==n){
                        cycle=true;
                    }
                }
            }
        }

        if(cycle){
            System.out.println(-1);
        }else{
            for (int i=2; i<=n; i++) {
                if (dist[i] == inf) dist[i] = -1;
                System.out.println(dist[i]);
            }
        }
    }
}
