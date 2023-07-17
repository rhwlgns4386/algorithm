package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N1463 {
    static int INF=1000001;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());

        int[] dp=new int[n+1];
        Arrays.fill(dp,INF);

        dp[1]=0;
        for(int i=2;i<=n;i++){
            if(i%2==0){
                dp[i]=Math.min(dp[i],dp[i/2]+1);
            }
            if(i%3==0){
                dp[i]=Math.min(dp[i],dp[i/3]+1);
            }
            dp[i]=Math.min(dp[i],dp[i-1]+1);
        }
        System.out.println(dp[n]);
    }
}
