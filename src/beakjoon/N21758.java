package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N21758 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(in.readLine());
        long[] a=new long[n];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for(int i=0;i<n;i++){
            a[i]=Long.parseLong(st.nextToken());
        }

        long[] left=new long[n];
        left[0]=a[0];
        for(int i=1;i<n;i++){
            left[i]+=left[i-1]+a[i];
        }


        long[] right=new long[n];
        right[n-1]=a[n-1];
        for(int i=n-2;0<=i;i--){
            right[i]+=right[i+1]+a[i];
        }

        long result=0;
        for(int i=1;i<n-1;i++){
            result=Math.max(result,(left[n-1]-a[0]-a[i])+(left[n-1]-left[i]));
        }

        for(int i=n-2;0<i;i--){
            result=Math.max(result,(right[0]-a[n-1]-a[i])+(right[0]-right[i]));
        }

        for(int i=1;i<=n-2;i++){
            result=Math.max(result,(left[i]-a[0])+(right[i]-a[n-1]));
        }
        System.out.println(result);
    }
}
