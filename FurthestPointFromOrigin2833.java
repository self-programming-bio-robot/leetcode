class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int r = 0;
        int l = 0;
        int s = 0;
        for (char c: moves.toCharArray()) {
            if (c == 'R') {
                r++;
            } else if (c == 'L') {
                l++;
            } else {
                s++;
            }
        }
        return (Math.max(l, r) - Math.min(l, r))  + s;
    }
}
