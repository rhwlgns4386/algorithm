package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N22341 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int N=Integer.parseInt(st.nextToken());
        int C=Integer.parseInt(st.nextToken());

        int A=N;
        int B=N;
        for(int i=0;i<C;i++){
            st=new StringTokenizer(in.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());

            if(x>=A || y>=B){
                continue;
            }

            if((B-y)*A>=(A-x)*B){
                A=x;
            }else{
                B=y;
            }
        }

        System.out.println(A*B);
    }
}
