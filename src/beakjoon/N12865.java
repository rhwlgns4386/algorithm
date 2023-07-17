package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N12865 {

    //bottom-up
    private static StringTokenizer tokenizer;
//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        tokenizer=new StringTokenizer(in.readLine()," ");
//        int n=Integer.parseInt(tokenizer.nextToken());
//        int k=Integer.parseInt(tokenizer.nextToken());
//
//        int[][] dp=new int[n+1][k+1];
//        int[] w=new int[n+1];
//        int[] v=new int[n+1];
//        for (int i = 1; i <= n; i++) {
//             tokenizer=new StringTokenizer(in.readLine()," ");
//             w[i]=Integer.parseInt(tokenizer.nextToken());
//             v[i]=Integer.parseInt(tokenizer.nextToken());
//        }
//
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= k; j++) {
//                 dp[i][j]=dp[i-1][j];
//                 if(j-w[i]>=0){
//                     dp[i][j]=Math.max(dp[i][j],dp[i-1][j-w[i]]+v[i]);
//                 }
//            }
//        }
//        System.out.println(dp[n][k]);
//    }

    //top-down

    static int n;
    static int[][] dp;
    static int[] w,v;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        tokenizer=new StringTokenizer(in.readLine()," ");
        n=Integer.parseInt(tokenizer.nextToken());
        int k=Integer.parseInt(tokenizer.nextToken());

        dp=new int[n+1][k+1];
        for (int i = 0; i < n+1; i++)
            for (int j = 0; j < k+1; j++)
                dp[i][j] = -1;

        w=new int[n+1];
        v=new int[n+1];
        for (int i = 1; i <= n; i++) {
            tokenizer=new StringTokenizer(in.readLine()," ");
            w[i]=Integer.parseInt(tokenizer.nextToken());
            v[i]=Integer.parseInt(tokenizer.nextToken());
        }

        System.out.println(value(1,k));
    }

    private static int value(int id, int k) {
        if(id==n+1 || k==0) return 0;
        if(dp[id][k]!=-1) return dp[id][k];
        if(w[id]>k) return value(id+1,k);
        dp[id][k]=Math.max(value(id+1,k),value(id+1,k-w[id])+v[id]);
        return dp[id][k];
    }
}
