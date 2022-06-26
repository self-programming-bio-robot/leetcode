public class MaximumPointsYouCanObtainFromCards1423 {
    public static void main (String[] args) {
        int[] test = new int[] { 1, 2, 3, 4, 5, 6, 1 }; // 3, 12
        System.out.println("excepted: 12");
        System.out.println("actual: " + new Solution().maxScore(test, 3));
    }
}

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int window = 0;
        int winSize = cardPoints.length - k;
        int minWindow = Integer.MAX_VALUE;

        for (int i = 0; i < cardPoints.length; i++) {
            if (i >= winSize) {
                window += cardPoints[i] - cardPoints[i - winSize];    
                minWindow = Math.min(minWindow, window);
            } else {
                window += cardPoints[i];
                minWindow = window;
            }
            sum += cardPoints[i];
        }

        return sum - minWindow;
    }
}
