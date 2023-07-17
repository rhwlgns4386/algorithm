package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N13458 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());

        StringTokenizer st = new StringTokenizer(in.readLine());
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(st.nextToken());
        }

        st=new StringTokenizer(in.readLine());
        int b=Integer.parseInt(st.nextToken());
        int c=Integer.parseInt(st.nextToken());
        long result=0;
        for(int i=0;i<n;i++){
            result++;
            int calc=a[i]-b;
            if(calc<=0) continue;
            result+=(int)Math.ceil(calc/(double)c);
        }

        System.out.println(result);
    }
}
