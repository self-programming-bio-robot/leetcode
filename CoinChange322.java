class Solution {
    public int coinChange(int[] coins, int sum) {
        int[] w = new int[sum+1];

        for (int i=1; i <= sum; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j <coins.length; j++){
                if(i - coins[j] >=0 && w[i - coins[j]] >-1) {
                    min = min > w[i -coins[j]] ? w[i - coins[j]] : min;
                }
            }
            if (min == Integer.MAX_VALUE)
                w[i] = -1;
            else
                w[i]= min + 1;
        }
        return w[sum];
    }
}
