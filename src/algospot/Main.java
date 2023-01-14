package algospot;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        int[] tems={1,3,5};
        int i = Arrays.binarySearch(tems, 10);
        System.out.println(i);
    }
}
