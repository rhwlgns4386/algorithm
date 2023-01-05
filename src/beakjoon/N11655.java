package beakjoon;

import java.io.*;
import java.util.ArrayList;

public class N11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Character> upperChar = new ArrayList<>();
        ArrayList<Character> lowerChar = new ArrayList<>();
        int a='a';
        int z='z';
        for(int i=a;i<=z;i++){
            char alphabet=(char)i;
            upperChar.add(Character.toUpperCase(alphabet));
            lowerChar.add(alphabet);
        }

        for(Character ch:bufferedReader.readLine().toCharArray()){
            if(Character.isUpperCase(ch)){
                int index=(upperChar.indexOf(ch)+13)%26;
                out.write(upperChar.get(index));
            }
            else if(Character.isLowerCase(ch)){
                int index=(lowerChar.indexOf(ch)+13)%26;
                out.write(lowerChar.get(index));
            }
            else {
                out.write(ch);
            }
        }

        out.flush();
        out.close();
        bufferedReader.close();

    }
}
