package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int e,s,m;
        e=s=m=1;

        StringTokenizer st = new StringTokenizer(in.readLine());
        int ie=Integer.parseInt(st.nextToken());
        int is=Integer.parseInt(st.nextToken());
        int im=Integer.parseInt(st.nextToken());
        for(int i=1;i<=7980;i++){
            if(e==ie && s==is && im==m){
                System.out.println(i);
                break;
            }

            e++;s++;m++;

            if(15<e){
                e=1;
            }
            if(28<s){
                s=1;
            }
            if(19<m){
                m=1;
            }
        }
    }
}
