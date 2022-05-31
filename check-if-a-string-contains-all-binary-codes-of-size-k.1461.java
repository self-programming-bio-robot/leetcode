public class CheckIfAStringContainsAllBinaryCodesofSizeK1461 {
    public static void main(String[] args) {
        System.out.println(new Solution().hasAllCodes("101000100011111001110010", 3));
    }
}

class Solution {
    public boolean hasAllCodes(String s, int k) {
        if (s.length() < k) return false;
        byte[] subsequences = new byte[1 << k];
        int subseq = s.charAt(0) - '0';
        for (byte i = 1; i < k; i++) {
            subseq = subseq << 1;
            subseq |= s.charAt(i) - '0';
        }
        subsequences[subseq] = 1; 

        int zerobit = ~(1 << k);
        int count = subsequences[subseq];
        for (int i = k; i < s.length(); i++) {
            subseq = ((subseq << 1) & zerobit) | (s.charAt(i) - '0');
            if (subsequences[subseq] == 0) {
                subsequences[subseq] = 1;
                count++;
            }
        }

        return count == 1 << k;    
    }
}
