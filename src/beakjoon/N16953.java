package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        long start=Long.parseLong(st.nextToken());
        long end=Long.parseLong(st.nextToken());
        int count=1;
        while (start<end){
            if(end%2==0){
                end/=2;
            }else if(end%10==1){
                end-=1;
                end/=10;
            }else{
                break;
            }
            count++;
        }

        if(start==end){
            System.out.println(count);
        }else{
            System.out.println(-1);
        }
    }
}
