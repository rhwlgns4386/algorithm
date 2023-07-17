package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2979 {
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken())*2;
        int c=Integer.parseInt(st.nextToken())*3;

        int[] time = new int[102];

        for(int i=0;i<3;i++){
            st = new StringTokenizer(in.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());

            for(;start<end;start++){
                time[start]+=1;
            }
        }

        int answer=0;
        for(int i=1;i<101;i++){
            if(time[i]==1){
                answer+=a;
            }else if(time[i]==2){
                answer+=b;
            }else if(time[i]==3){
                answer+=c;
            }
        }

        System.out.println(answer);
    }
}
