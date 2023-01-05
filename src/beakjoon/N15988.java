package beakjoon;

import java.io.*;
import java.util.Scanner;

public class N15988 {
    static final long mod = 1000000009L;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long[] d = new long[1000001];
        d[0] = 1;
        for (int i=1; i<=1000000; i++) {
            for (int j=1; j<=3; j++) {
                if (i-j >= 0) {
                    d[i] += d[i-j];
                }
            }
            d[i] %= mod;
        }
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(d[n]);
        }
    }
}
