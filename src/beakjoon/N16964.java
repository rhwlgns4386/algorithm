package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N16964 {

    public static ArrayList<Integer>[] a;
    public static int[] order;
    public static int cnt=0;
    public static boolean[] visit;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(in.readLine());
        a=(ArrayList<Integer>[]) new ArrayList[n];
        order=new int[n];
        visit=new boolean[n];
        for (int i = 0; i < n; i++) {
            a[i]=new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());
            int u=Integer.parseInt(stringTokenizer.nextToken())-1;
            int v=Integer.parseInt(stringTokenizer.nextToken())-1;
            a[u].add(v);
            a[v].add(u);
        }

        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine());
        for(int i=0;i<n;i++){
            order[i]=Integer.parseInt(stringTokenizer.nextToken())-1;
        }
        dfs(0);
        for(boolean check:visit){
            if(!check){
                System.out.println(0);
                System.exit(0);
            }
        }
        System.out.println(1);
    }

    public static void dfs(int s){
        if(visit[s]) return;
        visit[s]=true;
        if(cnt==n-1) return;
        cnt++;
        for(int i=0; i<a[s].size();i++){
            if(a[s].contains(order[cnt]) && !visit[order[cnt]]){
                dfs(order[cnt]);
            }
        }
    }
}
