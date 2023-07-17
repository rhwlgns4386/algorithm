package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N22343 {

    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(in.readLine());
        for(int i=0;i<T;i++){
            String s1 = in.readLine();
            String s2 = in.readLine();
            m=Math.max(s1.length(),s2.length())/2;

            int[] pa = sol2(s1);
            int[] pb = sol2(s2);
            System.out.println(Arrays.toString(pa));
            System.out.println(Arrays.toString(pb));
        }
    }

    public static int[] sol2(String s){
        int[] ret = new int[m + 1];
        int cur=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') cur++;
            else{
                cur--;
                if(s.charAt(i-1)=='('){
                    ret[cur]++;
                }
            }
        }

        for(int i=0;i<ret.length-1;i++){
            ret[i+1]+=ret[i]/2;
            ret[i]%=2;
        }

        return ret;
    }
}
