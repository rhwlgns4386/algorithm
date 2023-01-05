package beakjoon;

import java.util.Scanner;

public class N01_07 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String s = in.nextLine();
        char[] chars = s.toUpperCase().toCharArray();
        int lt=0,rt=s.length()-1;
        while (lt<rt){
            if(chars[lt]==chars[rt]){
                lt++;
                rt--;
            }
            else{
                break;
            }
        }
        if(lt>=rt){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}
