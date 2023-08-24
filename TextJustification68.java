import java.util.*;

public class TextJustification68 {
    public static void main(String[] args) {
        TestCase[] cases = new TestCase[] {
            new TestCase(
                new String[] { "This", "is", "an", "example", "of", "text", "justification." },
                16,
                new String[] {
                    "This    is    an",
                    "example  of text",
                    "justification.  "
                }
            ),
            new TestCase(
                new String[] { "What", "must", "be", "acknowledgment", "shall", "be" },
                16,
                new String[] { 
                    "What   must   be", 
                    "acknowledgment  ", 
                    "shall be        "
                }
            ),
            new TestCase(
                new String[] { "Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do" },
                20,
                new String[] { 
                    "Science  is  what we",
                    "understand      well",
                    "enough to explain to",
                    "a  computer.  Art is",
                    "everything  else  we",
                    "do                  "
                }
            )
        };

        for (TestCase c: cases) {
            System.out.println(c);
            List<String> actual = new Solution().fullJustify(c.words, c.maxWidth);
            System.out.println("actual " + actual);
            if (!actual.equals(c.expected)) {
                System.out.println("Error");
                return;
            }
        }
    }
}

class TestCase {
    public String[] words;
    public int maxWidth;
    public List<String> expected;

    public TestCase(String[] words, int maxWidth, String[] expected) {
        this.words = words;
        this.expected = List.of(expected);
        this.maxWidth = maxWidth;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Test case: ");
        sb.append(words);
        sb.append("\n");
        sb.append("max width: ").append(maxWidth);
        sb.append("\n");
        sb.append("expected: ").append(expected);
        return sb.toString();
    }
}

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int width = 0;
        int l = 0;
        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int gaps = i - l;
            if (width+word.length()+gaps <= maxWidth) {
                width += word.length();
            } else {
                gaps--;
                int spaces = maxWidth - width;
                int gapSize = gaps > 0 ? spaces / gaps : 0;
                int remains = gaps > 0 ? spaces % gaps : spaces;
                StringBuilder sb = new StringBuilder();

                for (int j = l; j < i; j++) {
                    int extra = remains-- > 0 ? 1 : 0;
                    sb.append(words[j]);
                    if (j < i-1) {
                        sb.append(" ".repeat(gapSize + extra));
                    } else {
                        sb.append(" ".repeat(Math.max(0,remains) + extra));
                    }
                }
                result.add(sb.toString());
                l = i;
                width = word.length();
            }
        }

        StringBuilder last = new StringBuilder();
        for (int j = l; j < words.length; j++) {
            last.append(words[j]);
            if (j < words.length - 1) {
                last.append(" ");
            }
        }
        if (last.length() > 0) {
            last.append(" ".repeat(maxWidth - last.length()));
            result.add(last.toString());
        }
        return result;
    }
}
