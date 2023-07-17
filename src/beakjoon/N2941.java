package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class N2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        String regex="(c=|c-|dz=|d-|lj|nj|s=|z=)";

        String s1 = s.replaceAll(regex, "");
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(s);

        int count=0;
        while (matcher.find()){
            count++;
        }

        System.out.println(s1.length()+count);
    }
}
