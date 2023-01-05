package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1005 {
    static int[] weight;
    static ArrayList<Integer>[] a;
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(in.readLine());
        while(T-->0){
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N=Integer.parseInt(st.nextToken());
            int K=Integer.parseInt(st.nextToken());

            a= (ArrayList<Integer>[]) new ArrayList[N + 1];
            weight=new int[N+1];
            dp=new long[N+1];
            Arrays.fill(dp,-1);

            boolean[] degree=new boolean[N+1];

            st=new StringTokenizer(in.readLine());
            for(int i=1;i<=N;i++){
                a[i]=new ArrayList<>();
                weight[i]=Integer.parseInt(st.nextToken());
            }

            for(int i=0;i<K;i++){
                st=new StringTokenizer(in.readLine());
                int from=Integer.parseInt(st.nextToken());
                int to=Integer.parseInt(st.nextToken());
                degree[to]=true;
                a[from].add(to);
            }

            long ans=0;
            int end=Integer.parseInt(in.readLine());
            for(int i=1;i<=N;i++){
               if(!degree[i]) ans=Math.max(dfs(i,end),ans);
            }
            System.out.println(ans);
        }
    }

    private static long dfs(int node, int end) {
        if(node==end) return weight[end];

        if(dp[node]!=-1) return dp[node];

        long ans=-Integer.MAX_VALUE;
        for(Integer n:a[node]){
            ans=Math.max(ans,dfs(n, end));
        }

        dp[node]=ans+weight[node];
        return dp[node];
    }
}
