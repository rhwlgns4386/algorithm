import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1495 {
    private static StringTokenizer tokenizer;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        tokenizer=new StringTokenizer(in.readLine()," ");
        int n=Integer.parseInt(tokenizer.nextToken());
        int s=Integer.parseInt(tokenizer.nextToken());
        int m=Integer.parseInt(tokenizer.nextToken());

        int[][] dp=new int[n+1][m+1];
        int[] v=new int[n+1];
        tokenizer=new StringTokenizer(in.readLine()," ");
        for (int i = 1; i <= n; i++) {
            v[i]=Integer.parseInt(tokenizer.nextToken());
        }

        dp[0][s]=1;

        for (int i = 0; i <= n-1; i++) {
            for(int j=0; j <= m; j++){
                if(dp[i][j]==0) continue;

                if (j-v[i+1] >= 0) {
                    dp[i+1][j-v[i+1]] = 1;
                }
                if (j+v[i+1] <= m) {
                    dp[i+1][j+v[i+1]] = 1;
                }
            }
        }
        int ans = -1;
        for (int i=0; i<=m; i++) {
            if (dp[n][i]==1) ans = i;
        }
        System.out.println(ans);
    }
}
