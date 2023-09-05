package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N26216 {

    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(in.readLine());
        int K = 50;
        int H = 50;
//        int Q = Integer.parseInt(st.nextToken());

        long count=0;
        for(int i=0;i<H;i++){
            int sum = (int) Math.pow((K + 1), i) + ((int) Math.pow((K + 1), (i - 1)) * K);
            count+=sum;
            if(i==H-1){
                count+=((int)Math.pow((K + 1), i))*K;
            }
        }
        System.out.println(count);
    }
}
