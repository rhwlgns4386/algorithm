package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2775 {

    private static long[][] dp;

    public static void main(String[] args) throws IOException {
        dp = new long[15][15];
        for(int i=1;i<15;i++){
            dp[0][i]=i;
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(in.readLine());
        while(T-->0){
            int k = Integer.parseInt(in.readLine());
            int n = Integer.parseInt(in.readLine());
            System.out.println(go(k,n));
        }
    }

    private static long go(int k, int n) {
        if(dp[k][n]!=0) return dp[k][n];

        for(int i=1;i<=n;i++){
            dp[k][n]+=go(k-1,i);
        }

        return dp[k][n];
    }
}
