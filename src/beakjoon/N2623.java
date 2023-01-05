package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N2623 {
    static boolean[] visit;
    static int[][] adj;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visit=new boolean[n+1];
        adj =new int[n+1][n+1];

        for(int i=0;i<m;i++){
            st=new StringTokenizer(in.readLine());
            st.nextToken();
            int start=Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()){
                int end=Integer.parseInt(st.nextToken());
                adj[start][end]=1;
                start=end;
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(!visit[i]){
                dfs(i,ans);
            }
        }

        ArrayList<Integer> print = print(n, ans);
        for(Integer i:print){
            System.out.println(i);
        }
    }

    private static ArrayList<Integer> print(int n, ArrayList<Integer> ans) {
        Collections.reverse(ans);
        for(int i = 0; i< ans.size(); i++){
            for(int j = i+1; j< ans.size(); j++){
                if(adj[ans.get(j)][ans.get(i)]==1)
                    return new ArrayList<Integer>(Arrays.asList(0));
            }
        }
        return ans;
    }

    static void dfs(int i, ArrayList<Integer> ans){
        visit[i]=true;
        for(int idx=1;idx<adj.length;idx++){
            if(adj[i][idx]==1 && !visit[idx]){
                dfs(idx,ans);
            }
        }
        ans.add(i);
    }
}
