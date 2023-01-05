package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class BigNum {
    public static void main(String[] args) {
        int[] num={3, 30, 34, 5, 9};
        String solution = solution(num);
        System.out.println("solution = " + solution);
    }

    public static String solution(int[] numbers) {
        StringBuffer answer = new StringBuffer();
        String[] strings = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        if(strings[0].equals("0")) return "0";
        for(String str:strings){
            answer.append(str);
        }
        return answer.toString();
    }
}
