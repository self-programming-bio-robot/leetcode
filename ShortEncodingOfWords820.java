import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

public class ShortEncodingOfWords820 {
    public static void main (String[] args) {
        // String[] words = new String[] { "time", "me", "bell" }; // 10
        String[] words = new String[] { "feipyxx","e" }; // 8

        System.out.println("expected: 8");
        System.out.println("actual: " + new Solution().minimumLengthEncoding(words));
    }
}

class Solution {
    public int minimumLengthEncoding(String[] words) {
        List<String>[] sortedWords = new List[] {
            new LinkedList(),
            new LinkedList(),
            new LinkedList(),
            new LinkedList(),
            new LinkedList(),
            new LinkedList(),
            new LinkedList()
        };

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            sortedWords[word.length() - 1].add(word);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = sortedWords.length - 1; i >= 0; i--) {
            List<String> row = sortedWords[i];
            for (Iterator<String> it = row.iterator(); it.hasNext();) {
                String word = it.next()+"#";
                if (sb.indexOf(word) < 0) {
                    sb.append(word);
                }
            }
        }

        return sb.length();
    }
}
