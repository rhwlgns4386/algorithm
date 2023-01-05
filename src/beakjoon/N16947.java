package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N16947 {
    public static int[] check;
    public static ArrayList<Integer>[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());
        check=new int[n];
        a=(ArrayList<Integer>[]) new ArrayList[n];
        for (int i = 0; i < n; i++) {
            a[i]=new ArrayList<>();

        }

        StringTokenizer tokenizer;
        for (int i = 0; i < n; i++) {
            tokenizer= new StringTokenizer(in.readLine()," ");
            int u=Integer.parseInt(tokenizer.nextToken())-1;
            int v=Integer.parseInt(tokenizer.nextToken())-1;
            a[u].add(v);
            a[v].add(u);
        }

        dfs(0,-1);

        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[n];

        for (int i = 0; i < n; i++) {
            if(check[i]==2){
                q.add(i);
                dist[i]=0;
            }
            else dist[i]=-1;
        }

        while (!q.isEmpty()){
            int x=q.remove();
            for(int y:a[x]){
                if(dist[y]==-1){
                    q.add(y);
                    dist[y]=dist[x]+1;
                }
            }
        }

        for (int i=0; i<n; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static int dfs(int x, int p){
        if(check[x]==1) return x;
        check[x]=1;
        for(int y:a[x]){
            if(y==p) continue;
            int res= dfs(y,x);
            if(res==-2) return -2;
            if(res>=0){
                check[x]=2;
                if(x==res) return -2;
                else return res;
            }
        }
        return -1;
    }
}
