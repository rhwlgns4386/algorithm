import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N12865 {
    private static StringTokenizer tokenizer;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        tokenizer=new StringTokenizer(in.readLine()," ");
        int n=Integer.parseInt(tokenizer.nextToken());
        int k=Integer.parseInt(tokenizer.nextToken());

        int[][] dp=new int[n+1][k+1];
        int[] w=new int[n+1];
        int[] v=new int[n+1];
        for (int i = 1; i <= n; i++) {
             tokenizer=new StringTokenizer(in.readLine()," ");
             w[i]=Integer.parseInt(tokenizer.nextToken());
             v[i]=Integer.parseInt(tokenizer.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                 dp[i][j]=dp[i-1][j];
                 if(j-w[i]>=0){
                     dp[i][j]=Math.max(dp[i][j],dp[i-1][j-w[i]]+v[i]);
                 }
            }
        }
        System.out.println(dp[n][k]);
    }
}
