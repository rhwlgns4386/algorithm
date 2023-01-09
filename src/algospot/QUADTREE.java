package algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.StringCharacterIterator;
import java.util.Arrays;
import java.util.StringTokenizer;

public class QUADTREE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C=Integer.parseInt(br.readLine().trim());

        for(int i=0;i<C;i++){
            System.out.println(solution(br.readLine()));
        }
    }

    private static String solution(String quadtree) {
        StringTokenizer stringTokenizer = new StringTokenizer(quadtree,quadtree,true);
        return go(stringTokenizer);
    }

    private static String go(StringTokenizer quadtree) {
        String next = quadtree.nextToken();
        if(next.equals("b")||next.equals("w")){
            return next+"";
        }

        String[] strs=new String[4];
        Arrays.fill(strs,"");

        strs[0]=go(quadtree);
        strs[1]=go(quadtree);
        strs[2]=go(quadtree);
        strs[3]=go(quadtree);

        return "x"+strs[2]+strs[3]+strs[0]+strs[1];
    }
}
