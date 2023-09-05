package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N15681 {
    static int[] dp;
    private static ArrayList<ArrayList<Integer>> a;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int n=Integer.parseInt(st.nextToken());
        int r=Integer.parseInt(st.nextToken());
        int q=Integer.parseInt(st.nextToken());

        dp=new int[n+1];
        Arrays.fill(dp,-1);

        a = new ArrayList<>();
        for(int i=0;i<n+1;i++){
            a.add(new ArrayList<>());
        }

        for(int i=0;i<n-1;i++){
            st=new StringTokenizer(in.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            a.get(u).add(v);
            a.get(v).add(u);
        }

        postorder(r);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<q;i++){
            sb.append(dp[Integer.parseInt(in.readLine())]);
            sb.append("\n");
        }
        System.out.println(sb);
    }


    private static int postorder(int here) {

        dp[here]=1;
        for(Integer next:a.get(here)){
            if(dp[next]==-1){
                dp[here]+=postorder(next);
            }
        }

        return dp[here];
    }
}
