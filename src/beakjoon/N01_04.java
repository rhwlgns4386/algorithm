package beakjoon;

import java.util.Scanner;

public class N01_04 {
    //test
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int input1 = in.nextInt();
        in.nextLine();
        for(int i=0;i<input1;i++){
            String reverse = new StringBuilder(in.nextLine()).reverse().toString();
            System.out.println(reverse);
        }
        return ;
    }
}
