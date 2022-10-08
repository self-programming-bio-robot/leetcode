class Solution {
    public String minWindow(String s, String t) {
        int target[] = new int[60];
        int targetCount = 0;
        for (int i = 0; i < t.length(); i++) { 
            int c = t.charAt(i) - 'A';
            if (target[c] == 0) targetCount += 1;
            target[c] += 1;
        }
        
        String res = "";
        boolean found = false;
        int[] count = new int[60];        

        int l = 0;
        int r = 0;
        int rightCount = 0;
        while (r < s.length()) {
            int c = s.charAt(r)-'A';
            count[c] += 1;
            
            if (count[c] == target[c]) {
                rightCount += 1;
            }
            
            while (rightCount == targetCount) {
                String buf = s.substring(l, r+1);
                if (!found || res.length() > buf.length()) {
                    res = buf;
                    found = true;
                }
                
                int lc = s.charAt(l)-'A';
                count[lc] -= 1;
                if (count[lc] < target[lc]) {
                    rightCount -= 1;
                }
                l++;
            }
            
            r++;
        }
        return res;
    }
}
