package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();

        int flag=-1;
        int zeroCount=0;
        int oneCount=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                if(flag!=0){
                    zeroCount++;
                    flag=0;
                }
            }else{
                if(flag!=1){
                    oneCount++;
                    flag=1;
                }
            }
        }

        System.out.println(Math.min(oneCount,zeroCount));
    }
}
