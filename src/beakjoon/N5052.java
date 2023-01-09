import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class N5052 {
    static class TrieNode {
        private Map<Character, TrieNode> nodes=new HashMap<Character, TrieNode>();
        public boolean isData=false;

        public boolean insert(String word){
            TrieNode node = add(word.charAt(0));
            if(node.isData==true){
                return false;
            }

            if(word.length()==1){
                node.isData=true;
                return true;
            }
            return node.insert(word.substring(1));
        }

        public TrieNode add(Character key){
            if(find(key)){
                return nodes.get(key);
            }
            TrieNode trieNode = new TrieNode();
            nodes.put(key,trieNode);
            return trieNode;
        }
        
        public boolean find(Character key){
            return nodes.containsKey(key);
        }
    }
    public static TrieNode rootNode;
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Integer t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            rootNode=new TrieNode();
            Integer integer=Integer.parseInt(br.readLine());
            boolean solution = solution(integer, br);
            System.out.println(solution==true?"YES":"NO");
        }
    }

    public static boolean solution(Integer count,BufferedReader br) throws IOException {
        ArrayList<String> list=new ArrayList<>();
        for(int i=0;i<count;i++){
            list.add(br.readLine());
        }
        list.sort(Comparator.naturalOrder());
        for(String s:list){
            boolean insert = rootNode.insert(s);
            if(insert==false){
                return false;
            }
        }
        return true;
    }
}
