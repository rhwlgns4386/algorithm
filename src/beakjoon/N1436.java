package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int k=Integer.parseInt(in.readLine());
        int cnt=0;
        for(int i=666;i<=10000000;i++){
            if(Integer.toString(i).contains("666")){
                cnt++;
            }
            if(cnt==k){
                System.out.println(i);
                break;
            }
        }
    }
}
