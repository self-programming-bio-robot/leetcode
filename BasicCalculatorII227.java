class Solution {
    public int calculate(String s) {
        Deque<Integer> numbers = new LinkedList();
        Deque<Character> op = new LinkedList();
        
        int num = 0;
        for (char c: s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '*' || c == '+' || c == '-' || c == '/') {
                if (!op.isEmpty() && (op.peek() == '*' || op.peek() == '/')) {
                    char o = op.pop();
                    int num2 = numbers.pop();
                    if (o == '*')
                        numbers.push(num * num2);
                    else
                        numbers.push(num2 / num);
                } else {
                    numbers.push(num);
                }
                num = 0;
                op.push(c);
            }
        }
        
        if (!op.isEmpty() && (op.peek() == '*' || op.peek() == '/')) {
            char o = op.pop();
            int num2 = numbers.pop();
            if (o == '*')
                numbers.push(num * num2);
            else
                numbers.push(num2 / num);
        } else {
            numbers.push(num);
        }
        
        int res = numbers.pollLast();
        while (!op.isEmpty()) {
            char o = op.pollLast();
            num = numbers.pollLast();
            
            if (o == '+') {
                res += num;
            } else if (o == '-') {
                res -= num;
            }
        }
        
        return res;
    }
}
