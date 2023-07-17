package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class N3447 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        System.in));

        String s="";
        while ((s=in.readLine())!=null){
            while (s.matches(".*BUG.*")){
                s=s.replaceAll("BUG","");
            }

            System.out.println(s);
        }
    }
}

