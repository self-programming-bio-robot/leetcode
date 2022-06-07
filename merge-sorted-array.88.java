public class MergeSortedArray88 {
    public static void main(String[] args) {
        int[] a = new int[] { 1, 2, 3, 0, 0, 0 };
        int[] b = new int[] { 2, 3, 4 };

        new Solution().merge(a, 3, b, 3);
        System.out.println("excepted: 1 2 2 3 3 4");
        System.out.print("actual:   ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = 0;
        int j = 0;
        int[] buf = new int[m];
        System.arraycopy(nums1, 0, buf, 0, m);
        for (int i = 0; i < nums1.length; i++) {
            if (k < m && (j >= n || buf[k] < nums2[j])) {
                nums1[i] = buf[k];
                k++;
            } else {
                nums1[i] = nums2[j];
                j++;
            }
        }
    }
}
