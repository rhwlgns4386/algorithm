package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N14002 {

    private static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());

        StringTokenizer st = new StringTokenizer(in.readLine());
        a = new int[n];
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(st.nextToken());
        }

        int[] record=new int[n];
        for(int i=0;i<n;i++){
            record[i]=i;
        }

        int[] dp=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(a[j]< a[i]){
                    if(dp[i]<dp[j]+1){
                        dp[i]=dp[j]+1;
                        record[i]=j;
                    }
                }
            }
        }

        int max=0;
        int index=0;
        for(int i=0;i<n;i++){
            if(max<dp[i]){
                max=dp[i];
                index=i;
            }
        }

        System.out.println(max);
        print(record,index);
    }

    private static void print(int[] record, int index) {
        if(record[index]==index){
            System.out.print(a[index]+" ");
            return;
        }
        print(record,record[index]);
        System.out.print(a[index]+" ");
    }
}
