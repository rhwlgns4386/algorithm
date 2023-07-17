package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class N2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());
        ArrayList<Integer> a = new ArrayList<>();

        for(int i=0;i<n;i++){
            a.add(Integer.parseInt(in.readLine()));
        }

        Collections.sort(a,Collections.reverseOrder());

        int max=0;
        for(int i=0;i<n;i++){
            int weight = a.get(i) * (i + 1);
            if(max<weight){
                max=Math.max(max,weight);
            }
        }

        System.out.println(max);
    }
}
