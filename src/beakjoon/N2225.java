package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2225 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine(), " ");
        int N=Integer.parseInt(stringTokenizer.nextToken());
        int K=Integer.parseInt(stringTokenizer.nextToken());
        int [][]dp=new int[K+1][N+1];
        dp[0][0]=1;

        for (int i = 1; i <= K; i++) {
            for (int j = 0; j <= N; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j]+=dp[i-1][k];
                    dp[i][j]%=1000000000;
                }

            }
        }
        System.out.println(dp[K][N]);
    }
}
