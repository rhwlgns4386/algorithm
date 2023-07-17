package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        boolean[] check = new boolean[100000 + 1];
        int sum = 0;
        for (int i = 0; i < 100000 / 5; i++) {
            sum += 5;
            check[sum] = true;
        }


        for (int i = 0; i <= n / 2; i++) {
            if (check[n - (i * 2)]) {
                System.out.println(((n - (i * 2)) / 5) + i);
                return;
            }else if(i*2==n){
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}
