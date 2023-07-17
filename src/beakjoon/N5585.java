package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N5585 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] money={500,100,50,10,5,1};

        int count=0;
        int input = 1000-Integer.parseInt(in.readLine());
        for(int i=0;i<6;i++){
            int tem=input/money[i];
            count+=tem;
            input-=tem*money[i];
        }

        System.out.println(count);
    }
}
