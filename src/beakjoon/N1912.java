package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int[] sequence=new int[N+1];
        int dp[]=new int[N+1];
        StringTokenizer tokenizer = new StringTokenizer(in.readLine(), " ");
        for (int i = 1; i < N+1; i++) {
            sequence[i]=Integer.parseInt(tokenizer.nextToken());
        }
        int max=sequence[1];
        for (int i = 1; i < N+1; i++) {
            dp[i]=sequence[i];
            dp[i]=Math.max(dp[i],dp[i-1]+sequence[i]);
            max=Math.max(max,dp[i]);
        }
        System.out.println(max);
    }
}
