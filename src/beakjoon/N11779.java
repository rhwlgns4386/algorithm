package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N11779 {
    static class Edge implements Comparable<Edge>{
        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            if(this.cost<o.cost){
                return -1;
            }
            else if(this.cost==o.cost){
                if(this.to<o.to){
                    return -1;
                }
                else if(this.to==o.to){
                    return 0;
                }
                else {
                    return 1;
                }
            }
            else return 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());
        int m=Integer.parseInt(in.readLine());

        StringTokenizer tokenizer;
        ArrayList<Edge>[] a = new ArrayList[n + 1];
        long[] dist=new long[n+1];
        int[] parent=new int[n+1];

        for (int i = 1; i <= n; i++) {
            a[i]=new ArrayList<>();
            parent[i]=i;
        }
        Arrays.fill(dist,Long.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            tokenizer= new StringTokenizer(in.readLine(), " ");
            int from=Integer.parseInt(tokenizer.nextToken());
            int to=Integer.parseInt(tokenizer.nextToken());
            int cost=Integer.parseInt(tokenizer.nextToken());
            a[from].add(new Edge(to,cost));
        }

        tokenizer=new StringTokenizer(in.readLine()," ");
        int start=Integer.parseInt(tokenizer.nextToken());
        int end=Integer.parseInt(tokenizer.nextToken());
        PriorityQueue<Edge> q = new PriorityQueue<>();
        q.add(new Edge(start,0));
        dist[start]=0;

        while (!q.isEmpty()){

            int here = q.peek().to;
            int cost = q.peek().cost;
            q.remove();

            if(dist[here]<cost) continue;

            for(Edge e:a[here]){
                if(dist[e.to]>dist[here]+e.cost){
                    dist[e.to]=dist[here]+e.cost;
                    parent[e.to]=here;
                    q.add(new Edge(e.to,(int)dist[e.to]));
                }
            }
        }

        System.out.println(dist[end]);
        find(parent,end,1);
    }

    static void find(int[] parent,int x,int cnt){
        if(parent[x]==x){
            System.out.println(cnt);
            System.out.print(x+" ");
            return;
        }

        find(parent,parent[x],cnt+1);
        System.out.print(x+" ");
        return;
    }
}
