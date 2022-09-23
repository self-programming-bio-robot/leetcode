class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> steps = new HashSet();
        while (n != 1 && !steps.contains(n)) {
            steps.add(n);
            n = next(n);
        }
        
        return n == 1;
    }
    
    private int next(int n) {
        int next = 0;
        while (n > 0) {
            next += Math.pow(n % 10, 2);
            n /= 10;
        }
        
        return next;
    }
}
