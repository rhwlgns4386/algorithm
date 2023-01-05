package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1309 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[][] dp=new int[N+1][3];
        for (int i = 0; i < 3; i++) {
            dp[1][i]=1;
        }

        for(int i=2;i<=N;i++){
            dp[i][0]=dp[i-1][0]+dp[i-1][1]+dp[i-1][2];
            dp[i][1]=dp[i-1][0]+dp[i-1][2];
            dp[i][2]=dp[i-1][0]+dp[i-1][1];
            for (int j=0; j<3; j++) {
                dp[i][j] %= 9901;
            }
        }
        System.out.println((dp[N][0]+dp[N][1]+dp[N][2])%9901);
    }
}
