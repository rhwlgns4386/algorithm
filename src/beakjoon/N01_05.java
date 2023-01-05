package beakjoon;

import java.util.Scanner;

public class N01_05 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String s = in.nextLine();
        int len=s.length();
        int lt=0,rt=len-1;
        char[] c=s.toCharArray();
        while(lt<rt){
            if(!Character.isAlphabetic(c[lt])){
                lt++;
            }else if(!Character.isAlphabetic(c[rt])){
                rt--;
            }
            else{
                char tem=c[lt];
                c[lt]=c[rt];
                c[rt]=tem;
                lt++;
                rt--;
            }
        }
        System.out.println(String.valueOf(c));
        return ;
    }
}
