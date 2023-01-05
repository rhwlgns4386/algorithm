package beakjoon;

import java.util.Scanner;

public class N01_02 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String input1 = in.next();
        int a='a';
        int sumNum=32;
        for(int i:input1.toCharArray()){
            if(i<a){
                i+=sumNum;
            }
            else{
                i-=sumNum;
            }
            System.out.print((char)i);
        }
        return ;
    }
}
