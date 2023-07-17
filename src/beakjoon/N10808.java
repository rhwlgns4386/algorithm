package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N10808 {
    public static void main(String[] args) throws IOException {

        int[] cnt = new int[26];

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();

        for(int i=0;i<s.length();i++){
            cnt[s.charAt(i)-'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<26;i++){
            sb.append(cnt[i]+" ");
        }

        System.out.println(sb);
    }
}
