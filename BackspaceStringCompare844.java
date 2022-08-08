class Solution {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        
        while (i >= 0 || j >= 0) {
            int buf = 0;
            while (i >= 0 && (s.charAt(i) == '#' || buf > 0)) {
                if (s.charAt(i) == '#') buf++; else buf--;
                i--;
            }
            buf = 0;
            while (j >= 0 && (t.charAt(j) == '#' || buf > 0)) {
                if (t.charAt(j) == '#') buf++; else buf--;
                j--;
            }
            
            if (i >= 0 && j >= 0) {
                if (s.charAt(i) == t.charAt(j)) {
                    i--;
                    j--;    
                } else {
                    return false;
                }
            } else if (i >= 0 || j >= 0) {
                return false;
            }
        }
        
        return true;
    }
}
