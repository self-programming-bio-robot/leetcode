class Solution {
    public int minPartitions(String n) {
        int max = 0;
        for (char c: n.toCharArray()){
            int i = c - '0';
            max = Math.max(max, i);
            if (max == 9) return max;
        }
        return max;
    }
}
