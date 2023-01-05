package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class N2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(in.readLine(), " ");
        int n=Integer.parseInt(tokenizer.nextToken());
        int k=Integer.parseInt(tokenizer.nextToken());

        TreeSet<Integer> nums=new TreeSet<>();
        int[] dp=new int[k+1];
        Arrays.fill(dp,10001);
        for (int i = 0; i < n; i++) {
            nums.add(Integer.parseInt(in.readLine()));
        }
        dp[0]=0;

        for (Integer num : nums) {
            for (int i = 1; i <= k; i++) {
                if(i-num>=0){
                    dp[i]=Math.min(dp[i],dp[i-num]+1);
                }
            }
        }
        System.out.println(dp[k]==10001?-1:dp[k]);
    }
}
