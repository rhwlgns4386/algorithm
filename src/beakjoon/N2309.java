package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class N2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Integer[] height=new Integer[9];
        for(int i=0;i<9;i++){
            height[i]=Integer.parseInt(in.readLine());
        }

        Arrays.sort(height, Collections.reverseOrder());

        go(height,0,0,0);
    }

    private static boolean go(Integer[] height, int index,int chose,int sum) {

        if(chose==7){
            if(sum==100){
                return true;
            }
            return false;

        }
        if(index==height.length){
            return false;
        }
        if(go(height,index+1,chose+1,sum+height[index])){
            System.out.println(height[index]);
            return true;
        }
        if(go(height,index+1,chose,sum)){
            return true;
        }
        return false;
    }
}
