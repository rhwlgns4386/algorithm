package programmers;

import java.util.ArrayList;
import java.util.Arrays;

public class KNumber {
    public static void main(String[] args) {
        String b="983";
        int compareTo = b.compareTo("984");
        System.out.println("compareTo = " + compareTo);
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] ints = new int[commands.length];
        for(int i=0;i<commands.length;i++){
            int[] subIntList = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(subIntList);
            ints[i]=subIntList[commands[i][2]-1];
        }
        return ints;
    }
}
