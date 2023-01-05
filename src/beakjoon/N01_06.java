package beakjoon;

import java.util.Scanner;

public class N01_06 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String s = in.nextLine();
        StringBuffer stringBuffer=new StringBuffer();
        for(int i=0;i<s.length();i++){
            if(i==s.indexOf(s.charAt(i)))stringBuffer.append(s.charAt(i));
        }
        System.out.println(stringBuffer.toString());
    }
}
