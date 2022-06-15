import java.util.List;
import java.util.ArrayList;

public class LongestStringChain1048 {
    public static void main (String[] args) {
        //String[] words = new String[] { "a","b","ba","bca","bda","bdca" }; // 4
        String[] words = new String[] { "a","ab","ac","bd","abc","abd","abdd" }; // 4
        //String[] words = new String[] { "xbc","pcxbcf","xb","cxbc","pcxbc" }; // 5
        //String[] words = new String[] { "abcd","dbqca" }; // 1
        System.out.println("excepted: 4");
        System.out.println("actual: " + new Solution().longestStrChain(words));
    }
}

class Solution {
    public int longestStrChain(String[] words) {
        int m = 16;
        List<List<String>> matrix = new ArrayList<>(m);
        List<List<Integer>> d = new ArrayList<>(m);
        for (int i = 0; i <= m; i++) {
            matrix.add(new ArrayList<>());
            d.add(new ArrayList<>());
        }

        for (int i = 0; i < words.length; i++) {
            matrix.get(words[i].length()).add(words[i]);
            d.get(words[i].length()).add(1);
        }

        int max = 1; 
        for (int i = 1; i < matrix.size(); i++) {
            List<String> row = matrix.get(i);
            List<String> prev = matrix.get(i-1);
            for (int j = 0; j < row.size(); j++) {
                for (int k = 0; k < prev.size(); k++) {
                    if (isPredecessor(prev.get(k), row.get(j))) {
                        int pv = d.get(i-1).get(k) + 1;
                        if (d.get(i).get(j) < pv) {
                            d.get(i).set(j, pv);
                        }
                        max = max < pv ? pv : max;
                    }
                }
            }
        }

        System.out.println(matrix);
        System.out.println(d);

        return max;
    }

    private boolean isPredecessor(String a, String b) {
        for (int i = 0, j = 0; i < a.length() && i+j < b.length();) {
            if (a.charAt(i) != b.charAt(i + j)) {
                j++;
            } else {
                i++;
            }
            if (j > 1) return false;
        }
        return true;
    }
}
