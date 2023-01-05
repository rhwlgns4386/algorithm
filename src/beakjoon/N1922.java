package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1922 {
    static class Edge implements Comparable<Edge>{
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight-o.weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());
        int m=Integer.parseInt(in.readLine());

        ArrayList<Edge>[] a = new ArrayList[n + 1];
        boolean[] visit = new boolean[n + 1];
        for(int i=1;i<=n;i++){
            a[i]=new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(in.readLine(), " ");
            int from=Integer.parseInt(stringTokenizer.nextToken());
            int to=Integer.parseInt(stringTokenizer.nextToken());
            int weight=Integer.parseInt(stringTokenizer.nextToken());
            a[from].add(new Edge(to,weight));
            a[to].add(new Edge(from,weight));
        }

        Queue<Edge> q = new PriorityQueue<>();
        visit[1]=true;
        for (Edge edge : a[1]) {
            q.add(edge);
        }

        int ans=0;
        while (!q.isEmpty()){
            Edge e = q.remove();
            if(visit[e.to]){
                continue;
            }
            visit[e.to]=true;
            ans+=e.weight;
            for (Edge edge : a[e.to]) {
                q.add(edge);
            }
        }
        System.out.println(ans);
    }
}
