public class MultiplyStrings43 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase("2", "3", "6"),
            new TestCase("123", "456", "56088"),
            new TestCase("25", "4", "100"),
            new TestCase("0", "0", "0"),
            new TestCase("999", "999", "998001"), 
            new TestCase("1234", "1", "1234"),
            new TestCase("1234", "0", "0"),
        };

        for (TestCase c: cases) {
            System.out.println(c);
            String actual = new Solution().multiply(c.num1, c.num2);
            System.out.println("actual " + actual);
            if (!c.expected.equals(actual)) return;
        }
    }
}

class TestCase {
    public String num1;
    public String num2;
    public String expected;

    public TestCase(String num1, String num2, String expected) {
        this.num1 = num1;
        this.num2 = num2;
        this.expected = expected;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test case: ");
        sb.append(num1).append(" ");
        sb.append(num2);
        sb.append("\n");
        sb.append("expected: ").append(expected);
        return sb.toString();
    }
}

class Solution {
    public String multiply(String num1, String num2) {
        String mul = mul(num1, num2);
        
        StringBuilder sb = new StringBuilder();
        boolean start = true;
        for (char c: mul.toCharArray()) {
            if (c != '0' || !start) {
                start = false;
                sb.append(c);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    private String mul(String num1, String num2) {
        if (num1.length() == 1 && num2.length() == 1) {
            String s = mulDigit(num1.charAt(0), num2.charAt(0));
            return s;
        }

        num1 = alignString(num1, num2);
        num2 = alignString(num2, num1);

        int len = num1.length();
        int hl = len - (len >> 1);
        int l = hl*2;

        String a = num1.substring(0, len - hl);
        String b = num1.substring(len - hl, len);
        String c = num2.substring(0, len - hl);
        String d = num2.substring(len - hl, len);

        String x1 = mul(sum(a, b), sum(c,d));
        String x2 = mul(a, c);
        String x3 = mul(b, d);
        return sum(
                    sum(x2 + "0".repeat(l), x3),
                    sub(
                        sub(x1, x2),
                        x3
                    ) + "0".repeat(hl)
                );
    }

    private String sum(String n1, String n2) {
        n1 = alignString(n1, n2);
        n2 = alignString(n2, n1);

        StringBuilder sb = new StringBuilder();

        boolean oh = false;
        for (int i = n1.length() - 1; i >= 0; i--) {
            int c = (n1.charAt(i) + n2.charAt(i) - '0' + (oh ? 1 : 0));
            
            if (c > '9') {
                oh = true;
                sb.insert(0, (char)(c - 10));
            } else {
                oh = false;
                sb.insert(0, (char)c);
            }
        }
        if (oh) sb.insert(0, '1');
        return sb.toString();
    }

    private String sub(String n1, String n2) {
        n1 = alignString(n1, n2);
        n2 = alignString(n2, n1);

        StringBuilder sb = new StringBuilder();

        boolean oh = false;
        for (int i = n1.length() - 1; i >= 0; i--) {
            int c = (n1.charAt(i) - n2.charAt(i) + '0' - (oh ? 1 : 0));

            if (c < '0') {
                oh = true;
                sb.insert(0, (char)(c + 10));
            } else {
                oh = false;
                sb.insert(0, (char)c);
            }
        }
        return sb.toString();
    }

    private String mulDigit(char d1, char d2) {
        return String.valueOf((d1 - '0') * (d2 - '0'));
    }

    private String alignString(String n1, String n2) {
        int len = n2.length() - n1.length();
        if (len > 0)
            return "0".repeat(len) + n1;
        return n1;
    }
}
