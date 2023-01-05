package programmers;

import java.util.*;

public class N43164 {


    public static void main(String[] args) {

    }
    public static String[] solution(String[][] tickets) {
        String[] answer = {};

        return answer;
    }



    static int makeTwentySixBinary(String str){
        int sum=0;
        for(char c:str.toCharArray()){
            int num=c-'A';
            sum=sum*26+num;
        }
        return sum;
    }

    static String twentySixBinaryToString(int binary){
        char[] c=new char[3];
        for(int i=2;0<=i;i--){
            int charNumber=binary%26+'A';
            c[i]=(char)charNumber;
            binary/=26;
        }
        return new String(c);
    }
}
