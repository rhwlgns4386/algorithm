package beakjoon;

import java.util.*;

class Edge {
    int from, to, cost;
    Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}
class EdgeComparator implements Comparator<Edge> {
    public int compare(Edge one, Edge two) {
        return Integer.compare(one.cost, two.cost);
    }
}

public class N1197 {
    public static void disjoint_union(int [] p, int x, int y) {
        x = find(p, x);
        y = find(p, y);
        if(x==y){
            return;
        }

        if(rank[x]<rank[y]) swap(x,y);
        p[y]=x;
        if(rank[x]==rank[y]){
            rank[x]=rank[y]+1;
        }

    }
    public static int find(int[] p, int x) {
        if (x == p[x]) {
            return x;
        } else {
            return (p[x] = find(p, p[x]));
        }
    }

    private static void swap(int x, int y) {
        int tem;
        tem=rank[x];
        rank[x]=rank[y];
        rank[y]=tem;
    }
    static int[] rank;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] p = new int[n+1];
        rank=new int[n+1];
        for (int i=0; i<=n; i++) {
            p[i] = i;
        }
        ArrayList<Edge> a = new ArrayList<Edge>();
        for (int i=0; i<m; i++) {
            a.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(a, new EdgeComparator());
        int ans = 0;
        for (Edge e : a) {
            int x = find(p, e.from);
            int y = find(p, e.to);
            if (x != y) {
                disjoint_union(p, e.from, e.to);
                ans += e.cost;
            }
        }
        System.out.println(ans);
    }
}