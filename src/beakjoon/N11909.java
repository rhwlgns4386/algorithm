package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N11909 {
    static int[] dx={0,1};
    static int[] dy={1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());
        int[][] map=new int[n][n];
        int[][] dp=new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(in.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j]=Integer.parseInt(tokenizer.nextToken());
                dp[i][j]=Integer.MAX_VALUE;
            }
        }

        dp[0][0]=0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(0<=i&&i<n-1&&0<=j &&j<n-1){
                    for(int k=0;k<2;k++){
                        int cnt=0;
                        if(map[i][j]<=map[i+dx[k]][j+dy[k]]){
                            cnt=map[i+dx[k]][j+dy[k]]-map[i][j]+1;
                        }
                        dp[i+dx[k]][j+dy[k]]=Math.min(dp[i+dx[k]][j+dy[k]],dp[i][j]+cnt);
                    }
                }

                else if(i==n-1&&0<=j&&j<n-1){
                    int cnt=0;
                    if(map[i][j]<=map[i][j+1]){
                        cnt=map[i][j+1]-map[i][j]+1;
                    }
                    dp[i][j+1]=Math.min(dp[i][j+1],dp[i][j]+cnt);
                }

                else if(0<=i&&i<n-1&&j==n-1){
                    int cnt=0;
                    if(map[i][j]<=map[i+1][j]){
                        cnt=map[i+1][j]-map[i][j]+1;
                    }
                    dp[i+1][j]=Math.min(dp[i+1][j],dp[i][j]+cnt);
                }
            }
        }

        System.out.println(dp[n-1][n-1]);
    }
}
