package main.java;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        System.out.println(Arrays.deepToString(merge(intervals1)));
    }

    private static int[][] merge(int[][] intervals) {
        ArrayList<int[] > arrayList = new ArrayList<>();

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        for(int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int a = interval[0];
            int b = interval[1];
            int j = i + 1;
            while( j < intervals.length && intervals[j][0] <= b) {
                b = intervals[j][1];
                j += 1;
            }
            arrayList.add(new int[]{a, b});
            i += j - i - 1;
        }
        int[][] result = new int[arrayList.size()][2];

        for(int i = 0; i < arrayList.size(); i++) {
            int[] aux = arrayList.get(i);
            result[i][0] = aux[0];
            result[i][1] = aux[1];
        }

        return result;
    }
}
