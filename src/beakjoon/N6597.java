package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class N6597 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = in.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(str);
            HashMap<Integer, Character> map = new HashMap<>();
            String preOrder = st.nextToken();
            for(int i=0;i<preOrder.length();i++){
                map.put(i,preOrder.charAt(i));
            }
            List<Character> collect = map.entrySet().stream()
                    .sorted((k1, k2) -> Integer.compare(k1.getKey(), k2.getKey()))
                    .map((e) -> e.getValue()).collect(Collectors.toList());
            String inOrder = st.nextToken();

            postOrder(collect,inOrder,inOrder.indexOf(preOrder.charAt(0)));
            System.out.println();
        }
    }

    private static void postOrder(List<Character> preOrder, String inOrder, int rootIndex) {
        if(inOrder.length()==0){
            return;
        }
        if(inOrder.length()==1){
            System.out.print(inOrder);
            return;
        }

        char root = inOrder.charAt(rootIndex);
        String left=inOrder.substring(0,rootIndex);
        int leftRootIndex = findRootIndex(preOrder, left);
        if(0<=leftRootIndex){
            postOrder(preOrder,left,leftRootIndex);
        }

        String right=inOrder.substring(rootIndex+1,inOrder.length());
        int rightRootIndex = findRootIndex(preOrder, right);
        if(0<=rightRootIndex){
            postOrder(preOrder,right,rightRootIndex);
        }
        System.out.print(root);
    }

    private static int findRootIndex(List<Character> preOrder, String left) {
        for(Character c:preOrder){
            int index = left.indexOf(c);
            if(0<=index){
                return index;
            }
        }
        return -1;
    }
}
