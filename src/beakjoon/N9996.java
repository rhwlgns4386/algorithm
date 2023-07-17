package beakjoon;

import java.util.Scanner;

public class N9996 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String pattern=in.next();
        int index = pattern.indexOf('*');
        String prefix = pattern.substring(0, index);
        String postfix = pattern.substring(index+1);

        for(int i=0;i<n;i++){
            String s = in.next();
            if(prefix.length()+postfix.length()>s.length()){
                System.out.println("NE");
            }else{
                if(s.substring(0,prefix.length()).equals(prefix) && s.substring(s.length()-postfix.length()).equals(postfix)){
                    System.out.println("DA");
                }else {
                    System.out.println("NE");
                }
            }
        }
    }

}
