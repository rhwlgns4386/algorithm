package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N1003 {
    private static ArrayList[] dp=new ArrayList[41];

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(in.readLine());
        while(T-->0){
            int n = Integer.parseInt(in.readLine());
            ArrayList<Integer> fibonacci = fibonacci(n);
            System.out.println(fibonacci.get(0)+" "+fibonacci.get(1));
        }

    }

    static ArrayList<Integer> fibonacci(int n) {
        if (n == 0) {
            return new ArrayList<Integer>(List.of(1,0));
        }
        if(n == 1){
            return new ArrayList<Integer>(List.of(0,1));
        }
        if(dp[n]!=null)return dp[n];
        ArrayList<Integer> fibonacci1 = fibonacci(n - 1);
        ArrayList<Integer> fibonacci2 = fibonacci(n - 2);
        return dp[n]=new ArrayList<Integer>(List.of(fibonacci1.get(0)+fibonacci2.get(0),fibonacci1.get(1)+fibonacci2.get(1))) ;
    }
}

