package groom.week3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<n;i++){
            a[i]+=a[i-1];
        }

        System.out.println(a[n-1]);
    }
}
