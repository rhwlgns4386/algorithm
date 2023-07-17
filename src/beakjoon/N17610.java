package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N17610 {
    static int[] a;
    static boolean[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());

        a = new int[n];
        StringTokenizer st = new StringTokenizer(in.readLine());
        int S=0;
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(st.nextToken());
            S+=a[i];
        }

        dp=new boolean[S+1];
        isMakeIt(0,0);

        int count=0;
        for(int i=1;i<=S;i++){
            if(!dp[i]){
                count++;
            }
        }

        System.out.println(count);
    }

    private static void isMakeIt(int index,int sum) {
        if(0<=sum) dp[sum]=true;
        if(index==a.length)return;
        isMakeIt(index+1,sum+a[index]);
        isMakeIt(index+1,sum-a[index]);
        isMakeIt(index+1,sum);
    }
}
