package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class HIndex {

    public static void main(String[] args) {
        int[] tem={3, 0, 6, 1, 5};
        System.out.println(solution(tem));
    }

    public static int solution(int[] citations) {
        Arrays.sort(citations);
        int len=citations.length;
        for(int i=0; i<citations.length;i++){
            int h=citations.length-i;
            if(h<=citations[i]){
                return h;
            }
        }
        return 0;
    }
}
