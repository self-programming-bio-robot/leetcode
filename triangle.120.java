import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int min = triangle.size() == 1 ? triangle.get(0).get(0) : Integer.MAX_VALUE;
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> pr = triangle.get(i - 1);
            List<Integer> cr = triangle.get(i);
            for (int j = 0; j < i + 1; j++) {
                int better = Math.min(
                    pr.get(Math.max(j-1, 0)), 
                    pr.get(Math.min(j, pr.size()-1))
                );
                cr.set(j, better + cr.get(j));
                if (i == triangle.size() - 1) {
                    min = min > cr.get(j) ? cr.get(j) : min;
                }
            }
        }
        return min;
    }
}
