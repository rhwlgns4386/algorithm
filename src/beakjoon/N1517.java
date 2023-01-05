package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1517 {
    public static int[] list;
    public static int[] tem;
    public static long cnt=0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        list = new int[n];
        tem = new int[n];

        StringTokenizer tokenizer = new StringTokenizer(in.readLine(), " ");
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(tokenizer.nextToken());
        }

        mergeSort(0, n-1);
        System.out.println(cnt);
    }

    private static void mergeSort(int left, int right) {
        if (left == right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(left, mid);
        mergeSort(mid + 1, right);
        merge(left, right);
    }

    private static void merge(int left, int right) {
        int mid = (left + right) / 2;
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (list[i] <= list[j]) tem[k++] = list[i++];
            else {
                cnt+=mid-i+1;
                tem[k++] = list[j++];
            }

        }
        while (i <= mid) tem[k++] = list[i++];
        while (j <= right) tem[k++] = list[j++];
        for (int l = left; l <= right; l++) {
            list[l] = tem[l - left];
        }
    }
}
