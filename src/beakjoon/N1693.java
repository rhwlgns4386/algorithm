package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1693 {

    private static ArrayList<ArrayList<Integer>> a;
    private static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());

        a = new ArrayList<>();
        for(int i=0;i<=n;i++){
            a.add(new ArrayList<>());
        }

        for(int i=1;i<n;i++){
            StringTokenizer st = new StringTokenizer(in.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            a.get(start).add(end);
            a.get(end).add(start);
        }

        int[] visit = new int[n + 1];
        dp = new long[n + 1];
        Arrays.fill(visit,-1);
        Arrays.fill(dp,0);
        bfs(visit,1);

        System.out.println(dp[1]);
    }

    private static int bfs(int[] visit,int here) {
        visit[here]=0;

        boolean[] check=new boolean[visit.length];
        for(Integer next:a.get(here)){
            if(visit[next]==-1){
                int choose = bfs(visit, next);
                check[choose]=true;
                dp[here]+=dp[next];
            }
        }


        for(int i=1;i<check.length;i++){
            if(!check[i]){
                dp[here]+=i;
                return i;
            }
        }

        dp[here]+=visit.length;
        return visit.length;
    }
}
