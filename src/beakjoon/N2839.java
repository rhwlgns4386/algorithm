package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N2839 {
    static int MAX=5001;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());

        int[] dp=new int[n+1];
        Arrays.fill(dp,MAX);
        dp[0]=0;
        for(int i=1;i<=n;i++){
            if(i-5>=0 && dp[i-5]!=MAX){
                dp[i]=Math.min(dp[i],dp[i-5]+1);
            }
            if(i-3>=0 && dp[i-3]!=MAX){
                dp[i]=Math.min(dp[i],dp[i-3]+1);
            }
        }

        if(dp[n]==MAX)System.out.println(-1);
        else System.out.println(dp[n]);
    }
}
