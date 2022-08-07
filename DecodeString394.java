class Solution {
    public String decodeString(String s) {
        Deque<Integer> stack = new LinkedList();
        Deque<StringBuilder> buffer = new LinkedList();
        
        int i = 0;
        int bufn = 0;
        buffer.push(new StringBuilder());
        stack.push(1);
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                bufn = bufn * 10 + (c - '0');
            } else if (c == '[') {
                stack.push(bufn);
                buffer.push(new StringBuilder());
                bufn = 0;
            } else if (c == ']') {
                int count = stack.poll();
                String ns = buffer.poll().toString().repeat(count);
                buffer.peek().append(ns);
            } else {
                buffer.peek().append(c);
            }
            i++;
        }

        return buffer.peek().toString();
    }
}
