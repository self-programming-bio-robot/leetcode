class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList();
        
        for (int i: asteroids) {
            if (i < 0) {
                
                while (!stack.isEmpty() && stack.peekLast() > 0 && stack.peekLast() < -i) {
                    stack.pollLast();
                }      
                if (stack.isEmpty() || stack.peekLast() < 0) {
                    stack.add(i);
                } else if (stack.peekLast() == -i) {
                    stack.pollLast(); 
                }
            } else {
                stack.add(i);
            }
        }
        
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}
