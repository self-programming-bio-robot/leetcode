import java.util.List;
import java.util.LinkedList;

public class NQueens51 {
    public static void main(String[] args) {
        var excepted = List.of(
                List.of(".Q..","...Q","Q...","..Q."),
                List.of("..Q.","Q...","...Q",".Q..")
        );

        System.out.println("Excepted:");
        System.out.println(excepted);
        System.out.println("Actual:");
        System.out.println(new Solution().solveNQueens(4));
    }
}

class Solution {
    public List<List<String>> solveNQueens(int n) {
        if (n == 1) return List.of(List.of("Q"));
        if (n < 4) return List.of();

        List<List<String>> results = new LinkedList<>();
        byte[][] field = new byte[n][n];
        byte[] line = new byte[n];
        byte[] rdiag = new byte[n];
        byte[] ldiag = new byte[n];
        lookForSolving(field, 0, line, rdiag, ldiag, results);
        return results;
    }

    private void lookForSolving(byte[][] f, int j, byte[] l, byte[] rd, byte[] ld, List<List<String>> res) {
        for (int i = 0; i < l.length; i++) {
            if (l[i] < 1 && rd[i] < 1 && ld[i] < 1) {
                if (j == l.length - 1) {
                    List<String> solving = new LinkedList<>();
                    f[j][i] = 1;
                    for (int y = 0; y < f.length; y++) {
                        String s = "";
                        for (int x = 0; x < f.length; x++) {
                            s = s + (f[y][x] == 0 ? "." : "Q");
                        }
                        solving.add(s);
                    }
                    f[j][i] = 0;
                    res.add(solving);
                } else {
                    f[j][i] = 1;
                    l[i] = 1;

                    byte[] rdb = new byte[rd.length];
                    System.arraycopy(rd, 0, rdb, 0, rd.length);
                    System.arraycopy(rd, 0, rd, 1, rd.length - 1);
                    rd[0] = 0;
                    if (i + 1 < rd.length) rd[i + 1] = 1;
                    byte[] ldb = new byte[ld.length];
                    System.arraycopy(ld, 0, ldb, 0, ld.length);
                    System.arraycopy(ld, 1, ld, 0, ld.length - 1);
                    if (i > 0) ld[i - 1] = 1;
                    ld[ld.length - 1] = 0;

                    lookForSolving(f, j + 1, l, rd, ld, res);

                    f[j][i] = 0;
                    l[i] = 0;

                    System.arraycopy(rdb, 0, rd, 0, rd.length);
                    System.arraycopy(ldb, 0, ld, 0, ld.length);
                }
            }
        }
    }
}
