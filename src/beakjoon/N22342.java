package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N22342 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int M=Integer.parseInt(st.nextToken());
        int N=Integer.parseInt(st.nextToken());

        int[][] map=new int[M][N];
        for(int i=0;i<M;i++) {
            String[] split = in.readLine().split("");
            for(int j=0;j<N;j++){
                map[i][j]=Integer.parseInt(split[j]);
            }
        }

        int[][] dp=new int[M][N];
        for(int i=0;i<M;i++){
            dp[i][0]=map[i][0];
        }

        int[] dx={-1,0,1};
        for(int j=1;j<N;j++){
            for(int i=0;i<M;i++){
                for(int k=0;k<3;k++){
                    int nx=i+dx[k];
                    if(0<=nx && nx<M){
                        dp[i][j]=Math.max(dp[i][j],dp[nx][j-1]);
                    }
                }
                dp[i][j]+=map[i][j];
            }
        }

        int result=0;
        for(int i=0;i<M;i++) {
            for(int j=0;j<N-1;j++){
                result=Math.max(dp[i][j],result);
            }
        }

        System.out.println(result);
    }
}
