import java.util.List;
import java.util.LinkedList;

public class SearchSuggestionsSystem1268 {
    public static void main (String[] args) {
        String[] words = new String[] {"mobile","mouse","moneypot","monitor","mousepad"};
        System.out.println(new Solution().suggestedProducts(words, "mouse"));
    }
}

class Solution {
        public List<List<String>> suggestedProducts(String[] products, String searchWord) {
            Node root = new Node();
            List<List<String>> res = new LinkedList<>();
            for (int i = 0; i < products.length; i++) {
                root.putString(products[i]);
            }
            for (int i = 1; i <= searchWord.length(); i++) {
                String s = searchWord.substring(0, i);
                List<String> row = searchSuggestions(root, s);
                res.add(row);
            }
            return res;
    }

    private List<String> searchSuggestions(Node r, String s) {
        Node n = r;
        for (int i = 0; i < s.length(); i++) {
            Node next = n.getNode(s.charAt(i));
            if (next == null) return new LinkedList();
            r=n;
            n = next;
        }
        List<String> res = new LinkedList();
        if (r.end) res.add(s);
        n.firstThree(s, res);
        return res;
    }
}

class Node {
    private Node[] s = new Node[26];
    public boolean end = false;


    public void putString(String sin) {
        if(sin.length() == 0) {
            return;
        }
        int first = sin.charAt(0) - 'a';
        s[first] = s[first]==null?new Node():s[first];
        s[first].end |= sin.length() == 1;
        if (sin.length() > 1)
            s[first].putString(sin.substring(1, sin.length()));
    } 

    public Node getNode(Character c) {
        return s[c - 'a'];
    }

    public int firstThree(String ss, List<String> list) {
        if (end) list.add(ss);
        if (list.size()==3) return 3;
        for (int i = 0; i < 26; i++) {
            if (s[i] != null && s[i].firstThree(ss + (char)('a' + i), list) == 3) 
                return 3;
        }
        return list.size();
    }
}
