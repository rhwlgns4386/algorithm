package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N19939 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());

        int sum=0;
        for(int i=1;i<=K;i++){
            sum+=i;
        }
        N-=sum;

        if(N<0){
            System.out.println(-1);
        }else{
           if(N%K==0){
               System.out.println(K-1);
           }else if(N%K!=0){
               System.out.println(K);
           }
        }
    }
}
