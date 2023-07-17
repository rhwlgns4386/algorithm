package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(in.readLine());

        for(int i=0;i<T;i++){
            StringBuilder word = new StringBuilder(in.readLine());

            int flowerPattern = isFlowerPattern(word);

            if(flowerPattern==2){
                flowerPattern=isFlowerPattern(word.reverse());
            }

            System.out.println(flowerPattern);
        }
    }

    private static int isFlowerPattern(StringBuilder word) {
        int result=0;
        int count=1;
        for(int j = 0, k = word.length()-1; j< Math.ceil(word.length()/(double)2); j++,k--){
            if(word.charAt(j)!= word.charAt(k)){
                if(count!=1){
                    result++;
                    break;
                }
                k++;
                result++;
                count--;
            }
        }

        return result;
    }
}
