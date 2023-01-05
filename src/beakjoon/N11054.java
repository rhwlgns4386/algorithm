package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(in.readLine());
        int a[]=new int[N];
        StringTokenizer tokenizer = new StringTokenizer(in.readLine(), " ");

        for (int i = 0; i < N; i++) {
            a[i]=Integer.parseInt(tokenizer.nextToken());
        }

        int dp[][]=new int[N][2];
        for (int i = 0; i < N; i++){
            dp[i][0]=1;
            for(int j=0;j<i;j++){
                if(dp[i][0]<dp[j][0]+1 && a[i]>a[j]){
                    dp[i][0]=dp[j][0]+1;
                }
            }
        }

        for (int i = N-1; i >= 0; i--){
            dp[i][1]=1;
            for(int j=N-1;j>i;j--){
                if(dp[i][1]<dp[j][1]+1 && a[i]>a[j]){
                    dp[i][1]=dp[j][1]+1;
                }
            }
        }

        int max=dp[0][0];
        for (int i = 0; i < N; i++) {
            max=Math.max(dp[i][0]+dp[i][1]-1,max);
        }

        System.out.println(max);
    }
}
