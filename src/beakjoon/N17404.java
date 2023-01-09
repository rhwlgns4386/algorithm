import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N17404 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int [][] dp=new int[1001][3];
        int [][] price=new int[1001][3];
        int N=Integer.parseInt(in.readLine());

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine()," ");
            for (int j = 0; j < 3; j++) {
                price[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < N; i++) {
            dp[i][0]=Math.min(dp[i-1][1],dp[i-1][2])+price[i][0];
            dp[i][1]=Math.min(dp[i-1][0],dp[i-1][2])+price[i][1];
            dp[i][2]=Math.min(dp[i-1][0],dp[i-1][1])+price[i][2];
        }
        System.out.println(Math.min(dp[N][0],Math.min(dp[N][1],dp[N][2])));
    }
}
