class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[][] inds = new int[mat.length][2];
        for (int i = 0; i < mat.length; i++) {
            inds[i][0] = i;
            inds[i][1] = soilders(mat[i]);
        }


        Arrays.sort(inds, (a,b) -> {
            int v = Integer.compare(a[1], b[1]);
            return v == 0 ? Integer.compare(a[0], b[0]) : v;
        });

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = inds[i][0];
        }
        return res;
    }

    int soilders(int[] row) {
        int l = 0;
        int r = row.length;

        while (l < r) {
            int m = (l + r) / 2;
            if (row[m] == 0) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return r;
    }
}
