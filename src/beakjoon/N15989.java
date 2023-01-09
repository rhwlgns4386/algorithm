import java.io.*;

public class N15989 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int t=Integer.parseInt(in.readLine());
        int limit=10000;
        int [] dp=new int [limit+1];
        int[] nums={1,2,3};
        dp[0]=1;

        for (int i=1; i<=limit; i++) {
            if (i-1 >= 0) {
                dp[i] += dp[i-1];
            }
        }
        for (int i=1; i<=limit; i++) {
            if (i-2 >= 0) {
                dp[i] += dp[i-2];
            }
        }
        for (int i=1; i<=limit; i++) {
            if (i-3 >= 0) {
                dp[i] += dp[i-3];
            }
        }

        for (int i = 0; i < t;i++) {
            int n=Integer.parseInt(in.readLine());
            out.write(dp[n]+"\n");
        }

        out.flush();
        out.close();
        in.close();
    }
}
