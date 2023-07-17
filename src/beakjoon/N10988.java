package beakjoon;

import java.util.Scanner;

public class N10988 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();

        int result=1;
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                result=0;
                break;
            }
        }

        System.out.println(result);
    }
}
