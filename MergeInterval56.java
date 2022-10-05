class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new LinkedList();
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);
        for (int[] interval: intervals) {
            if (res.size() > 0) {
                int[] last = res.get(res.size()-1);
                if (last[1] >= interval[0]) {
                    last[1] = Math.max(last[1], interval[1]);
                } else {
                    res.add(interval);
                }
            } else {
                res.add(interval);
            }
        }    
        return res.toArray(new int[0][2]);
    }
}
