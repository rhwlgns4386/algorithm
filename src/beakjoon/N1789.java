package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(in.readLine());
        long sum=0;
        long count=0;
        for(int i=1;;i++){
            if(sum>n) break;
            sum+=i;
            count++;
        }
        System.out.println(count-1);
    }
}
