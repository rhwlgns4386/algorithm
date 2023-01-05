package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(in.readLine(), " ");
        int n=Integer.parseInt(tokenizer.nextToken());
        int k=Integer.parseInt(tokenizer.nextToken());

        int[] nums=new int[n];
        int[] dp=new int[k+1];

        for (int i = 0; i < n; i++) {
            nums[i]=Integer.parseInt(in.readLine());
        }

        Arrays.sort(nums);
        dp[0]=1;
        for (int i = 0; i <n; i++) {
            for (int j = 1; j <= k; j++) {
                 if(j-nums[i]>=0){
                     dp[j]+=dp[j-nums[i]];
                 }
            }
        }

        System.out.println(dp[k]);
    }
}
