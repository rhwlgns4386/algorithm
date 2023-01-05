package beakjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1759 {
    public static ArrayList<String> save=new ArrayList<>();
    public static char[] checkArray={'a', 'e', 'i', 'o', 'u'};
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stringTokenizer = new StringTokenizer(in.readLine(), " ");
        int l=Integer.parseInt(stringTokenizer.nextToken());
        int c=Integer.parseInt(stringTokenizer.nextToken());

        char[] alphabet=in.readLine().replace(" ","").toCharArray();

        Arrays.sort(alphabet);

        go(alphabet,0,"",l);

        for(int i=0;i<save.size();i++){
            int count=0;
            String str=save.get(i);
            for(char ch:checkArray){
                if(str.contains(Character.toString(ch))){
                    count++;
                }
            }
            if(count>0 && str.length()-count>1){
                out.write(str+"\n");
            }
        }

        out.flush();
        out.close();
        in.close();
    }

    private static void go(char[] alphabet, int index, String password,int l) {
        if(password.length()==l) {
            save.add(password);
            return;
        }
        if(index==alphabet.length) return;
        go(alphabet,index+1,password+alphabet[index],l);
        go(alphabet,index+1,password,l);
    }
}
