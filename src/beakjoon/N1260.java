package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1260 {
    private static ArrayList<Integer>[] a;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine(), " ");

        int n=Integer.parseInt(stringTokenizer.nextToken());
        int m=Integer.parseInt(stringTokenizer.nextToken());
        int v=Integer.parseInt(stringTokenizer.nextToken());

        a=(ArrayList<Integer>[]) new ArrayList[n+1];
        visit=new boolean[n+1];
        for (int i = 1; i <= n; i++) {
             a[i]=new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            stringTokenizer=new StringTokenizer(in.readLine()," ");
             int node1=Integer.parseInt(stringTokenizer.nextToken());
             int node2=Integer.parseInt(stringTokenizer.nextToken());

             if(!a[node1].contains(node2)){
                 a[node1].add(node2);
                 a[node2].add(node1);
             }
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(a[i]);
        }
        dfs(v);
        Arrays.fill(visit,false);
        System.out.println("");
        bfs(v);
    }

    private static void bfs(int v) {
        Queue<Integer> q=new LinkedList<Integer>();
        q.add(v);
        visit[v]=true;


        while (!q.isEmpty()){
            int x=q.poll();
            System.out.print(x+" ");
            for (Integer integer : a[x]) {
                if(!visit[integer]){
                    visit[integer]=true;
                    q.add(integer);
                }
            }
        }
    }

    private static void dfs(int v) {
        if(visit[v]) return;
        visit[v]=true;
        System.out.print(v+" ");
        for (Integer integer : a[v]) {
            if(!visit[integer]){
                dfs(integer);
            }
        }
    }
}
