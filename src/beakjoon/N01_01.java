package beakjoon;

import java.util.Scanner;

public class N01_01 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input1 = in.next();
        Character input2 = in.next().toUpperCase().charAt(0);
        int count=0;
        for(char c:input1.toUpperCase().toCharArray()){
            if(input2.equals(c)){
                count++;
            }
        }
        System.out.println(count);
        return ;
    }
}
