class Solution {
    public String decodeAtIndex(String s, int k) {
        LinkedList<Couple> st = new LinkedList<>();
        
        long lk =  k - 1;
        s = s + "1";

        StringBuilder buf = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                int times = c - '0';
                String block = buf.toString();
                Couple prev = st.peek();
                buf.setLength(0);

                Couple newBlock = new Couple(
                    block, 
                    times, 
                    (prev == null ? block.length() : (prev.size + block.length())) * times
                );
                st.push(newBlock);
                if (newBlock.size > lk) {
                    break;
                }
            } else {
                buf.append(c);
            }
        }
        
        while (!st.isEmpty()) {
            Couple block = st.poll();
            Couple prev = st.peek();
            if (prev == null || prev.size <= lk) {
                long prevSize = prev == null ? 0 : prev.size;
                long blockSize = prevSize + block.block.length();
                long pos = lk % blockSize;

                if (pos < prevSize) {
                    lk = pos;
                } else {
                    return "" + block.block.charAt((int)(pos - prevSize));
                }
            }
        }

        return "";
    }

    static record Couple(
        String block,
        int count,
        long size
    ){}
}
