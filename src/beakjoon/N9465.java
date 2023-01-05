package beakjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(in.readLine());

        for (int i = 0; i < T; i++) {
            int n=Integer.parseInt(in.readLine());
            int[][] sticker=new int[n][2];
            StringTokenizer lineOne = new StringTokenizer(in.readLine()," ");
            StringTokenizer lineTwo = new StringTokenizer(in.readLine()," ");

            for (int j = 0; j < n; j++) {
                sticker[j][0]=Integer.parseInt(lineOne.nextToken());
                sticker[j][1]=Integer.parseInt(lineTwo.nextToken());
            }

            int[][] dp=new int[n][3];
            dp[0][1]=sticker[0][0];
            dp[0][2]=sticker[0][1];
            for (int j = 1; j < n; j++) {
                dp[j][0]=Math.max(dp[j-1][1],dp[j-1][2]);
                dp[j][1]=Math.max(dp[j-1][0],dp[j-1][2])+sticker[j][0];
                dp[j][2]=Math.max(dp[j-1][0],dp[j-1][1])+sticker[j][1];
            }

            System.out.println(Math.max(dp[n-1][0],Math.max(dp[n-1][1],dp[n-1][2])));
        }
    }
}
