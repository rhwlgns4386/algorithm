package beakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class N16934 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());
        Node root = new Node();

        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            String nickName = in.readLine();
            map.put(nickName,map.getOrDefault(nickName, 0)+1);
            int index=root.find(nickName,0);
            root.build(nickName,0);
            if(index==nickName.length()){
                Integer x = map.get(nickName);
                if(x==1)sb.append(nickName);
                else sb.append(nickName+x);
            }else{
                sb.append(nickName.substring(0,index+1));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static class Node {
        private HashMap<Character,Node> map;

        public Node() {
            this.map = new HashMap<>();
        }

        public int find(String nickName, int idx) {
            if(nickName.length()==idx) return idx;
            char here = nickName.charAt(idx);
            if(map.containsKey(here)){
                Node node = map.get(here);
                return node.find(nickName,idx+1);
            }
            return idx;
        }

        public void build(String nickName, int idx) {
            if(nickName.length()==idx) return;
            char here = nickName.charAt(idx);
            map.put(here,map.getOrDefault(here,new Node()));
            Node next = map.get(here);
            next.build(nickName, idx+1);
        }
    }
}
