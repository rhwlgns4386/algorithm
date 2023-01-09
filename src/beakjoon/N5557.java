import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N5557 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());
        n-=1;
        int[] a=new int[n];
        long[][] dp=new long[n][21];
        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine(), " ");
        for (int i = 0; i < n; i++) {
             a[i]=Integer.parseInt(stringTokenizer.nextToken());
        }
        int goal=Integer.parseInt(stringTokenizer.nextToken());

        dp[0][a[0]]=1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= 20; j++) {
                if(a[i]+j<=20){
                    dp[i][j]+=dp[i-1][j+a[i]];
                }

                if(j-a[i]>-1){
                    dp[i][j]+=dp[i-1][j-a[i]];
                }
            }
        }
        System.out.println(dp[n-1][goal]);
    }
}
