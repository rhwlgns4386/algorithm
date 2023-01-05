package groom.week3;

import java.io.*;
import java.util.*;

public class N2 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(in.readLine());
        ArrayList<String>[] list = new ArrayList[10];
        list[1]=new ArrayList<>(Arrays.asList("1",".",",","?","!"));
        list[2]=new ArrayList<>(Arrays.asList("2","A","B","C"));
        list[3]=new ArrayList<>(Arrays.asList("3","D","E","F"));
        list[4]=new ArrayList<>(Arrays.asList("4","G","H","I"));
        list[5]=new ArrayList<>(Arrays.asList("5","J","K","L"));
        list[6]=new ArrayList<>(Arrays.asList("6","M","N","O"));
        list[7]=new ArrayList<>(Arrays.asList("7","P","Q","R","S"));
        list[8]=new ArrayList<>(Arrays.asList("8","T","U","V"));
        list[9]=new ArrayList<>(Arrays.asList("9","W","X","Y","Z"));

        StringBuilder sb = new StringBuilder();
        char[] chars = in.readLine().toCharArray();
        int lastIndex=Character.getNumericValue(chars[0]);
        int cnt=0;
        for(int i=1;i<n;i++){
            int index=Character.getNumericValue(chars[i]);
            if(lastIndex==index){
                cnt++;
            }else{
                if(lastIndex==1||lastIndex==7||lastIndex==9){
                    sb.append(list[lastIndex].get(cnt%5));
                }else{
                    sb.append(list[lastIndex].get(cnt%4));
                }
                lastIndex=index;
                cnt=0;
            }
        }

        if(lastIndex==1||lastIndex==7||lastIndex==9){
            sb.append(list[lastIndex].get(cnt%5));
        }else{
            sb.append(list[lastIndex].get(cnt%4));
        }

        System.out.println(sb);
    }
}
