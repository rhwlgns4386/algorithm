package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N11722 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(in.readLine());
        StringTokenizer tokenizer = new StringTokenizer(in.readLine(), " ");
        int a[]=new int[N];
        int dp[]=new int[N];

        for (int i = 0; i < N; i++) {
            a[i]=Integer.parseInt(tokenizer.nextToken());
        }

        for (int i = N-1; i>=0; i--) {
            dp[i]=1;
            for (int j = N-1; j > i; j--) {
                if(a[i]>a[j] && dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                }
            }
        }

        int ans = dp[0];
        for (int i=0; i<N; i++) {
            ans=Math.max(ans,dp[i]);
        }
        System.out.println(ans);
    }
}
