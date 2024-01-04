package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N9997 {
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        int[] words = new int[N];
        for (int i = 0; i < N; i++) {
            String word = in.readLine();

            int wordBit = 0;
            for (int j = 0; j < word.length(); j++) {
                int alphabet = ((int) word.charAt(j)) - 'a';
                wordBit |= (1 << alphabet);
            }
            words[i] = wordBit;
        }

        go(words, 0, 0);
        System.out.println(result);
    }

    private static void go(int[] words, int idx, int mask) {
        if (idx == words.length) {
            if (mask == (1 << 26) - 1) {
                result++;
            }
            return;
        }

        go(words, idx + 1, mask | words[idx]);
        go(words, idx + 1, mask);
    }
}
