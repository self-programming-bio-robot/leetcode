// diffcult and less effective solution :(
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int l = bs(intervals, newInterval[0]);
        int r = bs(intervals, newInterval[1]);
        int il = l >> 1;
        int ir = r >> 1;
        
        System.out.println(l + " " + r);
        
        if ((l & 1) == 1) {
            int nn;
            if ((r & 1) == 1) {
                intervals[il][1] = intervals[ir][1];
                nn = n - ir + il;
                int[][] res = new int[nn][2];
                System.arraycopy(intervals, 0, res, 0, il+1);
                System.arraycopy(intervals, ir+1, res, il+1, n-ir-1);
                return res;
            } else {
                intervals[il][1] = newInterval[1];
                nn = n - ir + il + 1;
                int[][] res = new int[nn][2];
                System.arraycopy(intervals, 0, res, 0, il+1);
                System.arraycopy(intervals, ir, res, il+1, n-ir);
                return res;
            }
            
        } else {
            if ((r & 1) == 1) {
                int nn = n - ir + il;
                intervals[ir][0] = newInterval[0];
                int[][] res = new int[nn][];
                System.arraycopy(intervals, 0, res, 0, il+1);
                System.arraycopy(intervals, ir, res, il, n-ir);
                return res;
            } else {
                int nn = n - ir + il + 1;
                int[][] res = new int[nn][];
                if (l > 0) System.arraycopy(intervals, 0, res, 0, il);
                if (r < n*2-1) System.arraycopy(intervals, ir, res, il+1, n-ir);
                res[il] = newInterval;
                return res;
            }
        }     
    }
    
    private int bs(int[][] in, int i) {
        int l = 0;
        int r = in.length*2;
        while (l <= r) {
            int m = (l + r) / 2;
            
            if ((m & 1) == 1) {
                int j = (m >> 1);
                if (in[j][0] <= i && in[j][1] >= i) return m;
                
                if (in[j][0] > i) {
                    r = m;
                } else {
                    l = m + 1;
                }   
            } else {
                int j = (m >> 1);
                if ((j == in.length || in[j][0] > i) && (j == 0 || in[j-1][1] < i))
                    return m;
                
                if (in[j][0] > i) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }
        return l;
    }
}
