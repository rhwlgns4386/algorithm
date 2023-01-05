package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1890 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());
        int[][] board=new int[n][n];
        long[][] dp=new long[n][n];
        StringTokenizer stringTokenizer;

        for (int i = 0; i < n; i++) {
            stringTokenizer=new StringTokenizer(in.readLine()," ");
            for (int j = 0; j < n; j++) {
                board[i][j]=Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        dp[0][0]=1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j]==0) continue;
                if(j+board[i][j]<n){
                    dp[i][j+board[i][j]]+=dp[i][j];
                }
                if(i+board[i][j]<n){
                    dp[i+board[i][j]][j]+=dp[i][j];
                }
            }
        }
        System.out.println(dp[n-1][n-1]);
    }
}
