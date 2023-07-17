package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class N2870 {
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());

        Pattern pattern = Pattern.compile("[0-9]+");
        ArrayList<BigInteger> a = new ArrayList<>();
        for(int i=0;i<n;i++){
            Matcher matcher = pattern.matcher(in.readLine());
            while (matcher.find()){
                a.add(new BigInteger(matcher.group()));
            }
        }

        Collections.sort(a);
        for(BigInteger i:a){
            System.out.println(i);
        }
    }
}
