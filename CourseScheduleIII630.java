public class CourseScheduleIII630 {
    public static void main (String[] args) {
        int[][] testCase = new int[][] {
            {100, 200}, {200, 1300}, {1000, 1200}, {2000, 32000}
        };

        System.out.println("Excepted: 3");
        System.out.println("Actual: " + new Solution().scheduleCourse(testCase));
    }
}

class Solution {

    public int scheduleCourse(int[][] courses) {
        int lastDay = 0;
        for (int[] course: courses) {
            lastDay = Math.max(course[1], lastDay);
        }

        int[] d = new int[lastDay + 1];

        int j = 0;
        int res = 0;
        for (int i = 1; i <= lastDay; i++) {
            int w = courses[j][1] >= i ? courses[j][0] : 0;
            d[i] = Math.max(
                    d[i],
                    (i >= w ? d[i - w] : 0) + (courses[j][1] >= i ? 1 : 0) 
                );
            res = Math.max(res, d[i]);
        }

        return res;
    }
}
