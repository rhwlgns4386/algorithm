package beakjoon;

import java.util.*;
class Pair {
    long row, col;
    Pair(long row, long col) {
        this.row = row;
        this.col = col;
    }
}
public class N1891 {
    static Pair go(String a, int index, long r, long c, long size) {
        if (size == 1) {
            return new Pair(r,c);
        } else {
            long m = size/2;
            if (a.charAt(index) == '1') {
                return go(a, index+1, r, c+m, m);
            } else if (a.charAt(index) == '2') {
                return go(a, index+1, r, c, m);
            } else if (a.charAt(index) == '3') {
                return go(a, index+1, r+m, c, m);
            } else if (a.charAt(index) == '4') {
                return go(a, index+1, r+m, c+m, m);
            }
        }
        return new Pair(0, 0);
    }
    static String gogo(long r, long c, long size, long x, long y) {
        if (size == 1) {
            return "";
        }
        long m = size/2;
        if (x < r+m && y < c+m) {
            return "2" + gogo(r, c, m, x, y);
        } else if (x < r+size/2 && y >= c+m) {
            return "1" + gogo(r, c+m, m, x, y);
        } else if (x >= r+size/2 && y < c+m) {
            return "3" + gogo(r+m, c, m, x, y);
        } else {
            return "4" + gogo(r+m, c+m, m, x, y);
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String a = sc.next();
        long size = (1L << n);
        Pair p = go(a, 0, 0, 0, size);
        long dc = sc.nextLong();
        long dr = sc.nextLong();
        dr = -dr;
        p.row += dr;
        p.col += dc;
        if (0 <= p.row && p.row < size && 0 <= p.col && p.col < size) {
            System.out.println(gogo(0, 0, size, p.row, p.col));
        } else {
            System.out.println(-1);
        }
    }
}