package algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TILING2 {
    private static int[] dp = new int[101];
    private static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        int C=Integer.parseInt(bufferedReader.readLine());
        for(int i=0;i<C;i++){
            System.out.println(go(Integer.parseInt(bufferedReader.readLine())));
        }
    }

    public static int go(int n) {
        if (n <= 1) return 1;
        if (dp[n] != 0) return dp[n];
        int result = (go(n - 1) + go(n - 2)) % MOD;
        dp[n] = result;
        return dp[n];
    }
}
