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
        System.out.println(Integer.toBinaryString(subseq));
        for (byte i = 1; i < k; i++) {
            subseq = subseq << 1;
            subseq |= s.charAt(i) - '0';
        }
        
        System.out.println(Integer.toBinaryString(subseq));
        subsequences[subseq] = 1; 

        int zerobit = ~(1 << k);
        for (int i = k; i < s.length(); i++) {
            subseq = ((subseq << 1) & zerobit) | (s.charAt(i) - '0');
            subsequences[subseq] = 1;
        }

        for (int i = 0; i < subsequences.length; i++) {
            if (subsequences[i] == 0)
                return false;
        }
        return true;        
    }
}
