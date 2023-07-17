package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class N10610 {
        public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        ArrayList<Integer> a = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            a.add(Integer.parseInt(s.charAt(i)+""));
        }

        if(a.contains(0)){
            int sum = a.stream().mapToInt(i -> (int) i).sum();
            if(sum%3==0){
                Collections.sort(a,Collections.reverseOrder());
                for(int i=0;i<a.size();i++){
                    System.out.print(a.get(i));
                }
                return;
            }
        }
        System.out.println(-1);
    }

}
