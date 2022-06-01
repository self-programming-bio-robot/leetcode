import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.Comparator;

public class RussianDollEnvelopes354 {
    public static void main(String[] args) {
        int[][] inp = {{30,50},{12,2},{3,4},{12,15}};
//        int[][] inp = {{5,4},{6,4},{6,7},{2,3}};
//        int[][] inp = {{1,3},{3,5},{6,7},{6,8}, {8,4}, {9,5}};
//        int[][] inp = {{46,89},{50,53},{52,68},{72,45},{77,81}};
//        int[][] inp = {{4,5},{4,6},{6,7},{2,3},{1,1}};
        System.out.println(new Solution().maxEnvelopes(inp));
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }
}

class Solution {
    public int maxEnvelopes(int[][] e) {
        Arrays.sort(e, (a, b) -> a[0] == b[0] ? (b[1] - a[1]) : a[0] - b[0]);

        int[] d = new int[e.length + 1];
        int max = 0;
        d[0] = -1;

        for (int i = 1; i < d.length; i++) {
            d[i] = Integer.MAX_VALUE;
        }
        
        for (int i = 0; i < e.length; i++) {
            int j = binarySearch(d, e[i][1]);
            if (d[j] > e[i][1]) {
                d[j] = e[i][1];

                max = max < j ? j : max;
            }
        }

        for (int i = 0; i < d.length; i++) {
            System.out.println(d[i]);
        }

        return max;
    } 

    private int binarySearch(int[] d, int a) {
        int l = 0;
        int r = d.length;

        while (l + 1 < r) {
            int c = (l + r) / 2;
            if (a > d[c]) {
                l = c;
            } else {
                r = c;
            }
        }

        return r;
    }
}
