package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[] wines = new int[N];
        int[][] dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            wines[i]=Integer.parseInt(in.readLine());
        }
        dp[0][1]=wines[0];
        for (int i = 1; i < N; i++) {
            dp[i][0]=Math.max(dp[i-1][1],Math.max(dp[i-1][2],dp[i-1][0]));
            dp[i][1]=dp[i-1][0]+wines[i];
            dp[i][2]=dp[i-1][1]+wines[i];
        }

        System.out.println(Math.max(dp[N-1][0],Math.max(dp[N-1][1],dp[N-1][2])));
    }
}
