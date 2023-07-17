package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class N2857 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String regex="FBI";

        StringBuilder sb = new StringBuilder();
        Pattern compile = Pattern.compile(regex);
        for(int i=1;i<=5;i++){
            if(compile.matcher(in.readLine()).find()){
                sb.append(i+" ");
            }
        }

        if(sb.length()==0){
            System.out.println("HE GOT AWAY!");
        }else{
            System.out.println(sb);
        }
    }
}
