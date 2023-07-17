package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class N1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());

        PriorityQueue<Integer> minus = new PriorityQueue<>();
        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            int input = Integer.parseInt(in.readLine());
            if(input<=0){
                minus.add(input);
            }else{
                plus.add(input);
            }
        }

        int result=0;
        while (!minus.isEmpty()){
            Integer i = minus.remove();
            if(minus.isEmpty()){
                result+=i;
            }else{
                Integer next = minus.remove();
                result+=next*i;
            }
        }

        while (!plus.isEmpty()){
            Integer i = plus.remove();
            if(plus.isEmpty()){
                result+=i;
            }else{
                Integer next = plus.remove();
                if(next==1){
                    result+=i+next;
                }
                else{
                    result+=i*next;
                }
            }
        }

        System.out.println(result);
    }
}
