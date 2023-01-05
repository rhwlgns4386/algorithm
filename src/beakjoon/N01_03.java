package beakjoon;

import java.util.Scanner;

public class N01_03 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input1 = in.nextLine();
        String[] s = input1.split(" ");
        int maxLength=0;
        String output=new String();
        for(String str:s){
            if(maxLength<str.length()){
                maxLength=str.length();
                output=str;
            }
        }
        System.out.println(output);
        return ;
    }
}
