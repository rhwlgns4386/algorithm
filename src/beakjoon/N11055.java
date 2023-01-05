package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(in.readLine());
        StringTokenizer tokenizer = new StringTokenizer(in.readLine(), " ");
        int a[]=new int[N];
        int dp[]=new int[N];

        for (int i = 0; i < N; i++) {
             a[i]=Integer.parseInt(tokenizer.nextToken());
        }

        for (int i = 0; i < N; i++) {
            dp[i]=a[i];
            for (int j = 0; j < i; j++) {
                if(a[i]>a[j] && dp[i]<dp[j]+a[i]){
                    dp[i]=dp[j]+a[i];
                }
            }
        }

        int ans = dp[0];
        for (int i=0; i<N; i++) {
            if (ans < dp[i]) {
                ans = dp[i];
            }
        }
        System.out.println(ans);
    }
}
