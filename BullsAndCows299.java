public class BullsAndCows299 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase("1807", "7810", "1A3B"),
            new TestCase("1123", "0111", "1A1B"),
        };

        for (TestCase c: cases) {
            System.out.println(c);
            String actual = new Solution().getHint(c.secret, c.guess);
            System.out.println("actual " + actual);
            if (!c.expected.equals(actual)) return;
        }
    }
}

class TestCase {
    public String secret;
    public String guess;
    public String expected;

    public TestCase(String secret, String guess, String expected) {
        this.secret = secret;
        this.guess = guess;
        this.expected = expected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test case: ");
        sb.append(secret).append(" ").append(guess);
        sb.append("\n");
        sb.append("expected: ").append(expected);
        return sb.toString();
    }
}

class Solution {
    public String getHint(String secret, String guess) {
        int correct = 0;
        int rearranged = 0;
        int[] cS = new int[10];
        int[] cG = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                correct++;
            } else {
                cS[secret.charAt(i) - '0']++;
                cG[guess.charAt(i) - '0']++;
            }
        }

        for (int i = 0; i < 10; i++) {
            rearranged += Math.min(cS[i], cG[i]);
        }

        return correct + "A" + rearranged + "B";       
    }
}
