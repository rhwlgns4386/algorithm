package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N10162 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] times={300,60,10};
        int T=Integer.parseInt(in.readLine());

        int[] counts = new int[3];
        for(int i=0;i<3;i++){
             int len=T/times[i];
             counts[i]=len;
             T-=len*times[i];
        }

        if(T!=0){
            System.out.println(-1);
        }else{
            for(int i=0;i<3;i++){
                System.out.print(counts[i]+" ");
            }
        }
    }
}
