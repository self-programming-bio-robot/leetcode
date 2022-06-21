import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;

public class SearchSuggestionsSystem1268 {
    public static void main (String[] args) {
        String[] words = new String[] {"mobile","mouse","monitors","moneypot","monitor","mousepad"};
        System.out.println(new Solution().suggestedProducts(words, "mouse"));
    }
}

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> res = new LinkedList();
        for (int i = 1; i <= searchWord.length(); i++) { 
            String subs = searchWord.substring(0, i);
            int k = bs(products, subs, 0, products.length-1);
            System.out.println(subs);
            System.out.println(products[k]);
            List<String> row = new LinkedList();
            for (int j = k; j < k + 3 && j < products.length; j++){
                if (products[j].indexOf(subs) == 0)
                    row.add(products[j]);
            }
            res.add(row);
        }
        return res;
    }

    private int bs(String[] p, String s, int l, int r) {
        while (l+1 < r) {
            int m = (l + r) / 2;
            if (p[m].compareTo(s) >= 0) {
                r = m;
            } else {
                l = m;
            }

        }
        return p[l].indexOf(s) == 0 ? l : r;
    }
}

