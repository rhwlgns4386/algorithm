package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;

public class N2670 {
    //누적합으로 풀시 NAN뜸
    public static void main(String[] args) throws IOException {

        int n=10000;
        Double[] a = new Double[n];

        double max=0;
        for (int i = 0; i <n ; i++) {
            a[i]=new Double(9.9);
            max=Math.max(a[i],max);
        }


        for (int i = 1; i <n ; i++) {
            a[i]*=a[i-1];
            max=Math.max(a[i],max);
        }

        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                max=Math.max(a[j]/a[i],max);
            }
        }

        System.out.println(String.format("%.3f",max));

//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//
//        int n=Integer.parseInt(in.readLine());
//        double[] a = new double[n];
//
//        double max=0;
//        for (int i = 0; i <n ; i++) {
//            a[i]=Double.parseDouble(in.readLine());
//            max=Math.max(a[i],max);
//        }
//
//
//        for (int i = 1; i <n ; i++) {
//            a[i]*=a[i-1];
//            max=Math.max(a[i],max);
//        }
//
//        for(int i=0;i<n-1;i++){
//            for(int j=i+1;j<n;j++){
//                max=Math.max(a[j]/a[i],max);
//            }
//        }
//
//        System.out.println(String.format("%.3f",max));
    }
}


