package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N6137 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringBuilder S = new StringBuilder();
        for(int i=0;i<N;i++){
            S.append(br.readLine());
        }

        StringBuilder result = new StringBuilder();
        while (S.length()!=0){
            if(S.charAt(0)<S.charAt(S.length()-1)){
                result.append(S.charAt(0));
                S.deleteCharAt(0);
            }else if(S.charAt(0)>S.charAt(S.length()-1)){
                result.append(S.charAt(S.length()-1));
                S.deleteCharAt(S.length()-1);
            }else{
                String reverse = S.reverse().toString();
                S.reverse();
                if(S.toString().compareTo(reverse)<=0){
                    result.append(S.charAt(0));
                    S.deleteCharAt(0);
                }else{
                    result.append(S.charAt(S.length()-1));
                    S.deleteCharAt(S.length()-1);
                }
            }

            if(result.length()==80){
                System.out.println(result);
                result=new StringBuilder();
            }

        }

        if(result.length()!=0){
            System.out.println(result);
        }
    }
}
