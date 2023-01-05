package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N11048 {
    public static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        st=new StringTokenizer(in.readLine()," ");
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        int[][] A=new int[N+1][M+1];
        int[][] dp=new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            st=new StringTokenizer(in.readLine()," ");
            for (int j = 1; j <= M; j++) {
                A[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j])+A[i][j];
            }
        }

        System.out.println(dp[N][M]);
    }
}
