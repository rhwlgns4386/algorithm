package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1038 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());

        if(n<11){
            System.out.println(n);
            System.exit(0);
        }

        if(n>=1023){
            System.out.println(-1);
            System.exit(0);
        }

        int count=10;
        long num=11;
        while(true){
            String s = String.valueOf(num);
            char[] chars = s.toCharArray();
            boolean check=true;
            int tem=0;
            for(int i=1;i<chars.length;i++){
                if(chars[i]>=chars[i-1]){
                    check=false;
                    tem=i;
                    break;
                }
            }
            if(check){
                ++count;
            }
            if(count==n){
                break;
            }
            if(check){
                ++num;
            }
            else {
                int pow = (int) Math.pow(10, chars.length-tem);
                num=Long.parseLong(s.substring(0,tem))*pow+pow;
            }

        }
        System.out.println(num);
    }
}
