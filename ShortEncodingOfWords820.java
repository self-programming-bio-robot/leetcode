import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

public class ShortEncodingOfWords820 {
    public static void main (String[] args) {
        //String[] words = new String[] { "me","time" }; // 5
        //String[] words = new String[] { "time", "me", "bell" }; // 10
        String[] words = new String[] { "feipyxx","e" }; // 10

        System.out.println("expected: 10");
        System.out.println("actual: " + new Solution().minimumLengthEncoding(words));
    }
}

class Solution {
    public int minimumLengthEncoding(String[] words) {
        Node root = new Node();
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            root.putString(word, word.length()-1);
        }

        return root.sumLength(0);
    }
}

class Node {
    private Node[] s = new Node[26];
    private boolean isLeaf = true;

    public void putString(String sin, int i) {
        if (i < 0) return;
        int first = sin.charAt(i) - 'a';
        isLeaf = false;
        s[first] = s[first] == null ? new Node() : s[first]; 
        s[first].putString(sin, i-1);
    } 

    public int sumLength(int i) {
        if (isLeaf) return i + 1;

        int sum = 0;
        for (int j = 0; j < 26; j++) {
            if (s[j] != null)
                sum += s[j].sumLength(i+1);
        }

        return sum;
    }
}
