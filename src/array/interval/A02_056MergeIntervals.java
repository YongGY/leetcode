package array.interval;

import java.util.*;

import common.Interval;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * Example 1:
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * 
 * Example 2:
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
 * 
 * @author William
 *
 */
public class A02_056MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        // Sort by ascending starting point using an anonymous Comparator
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        List<Interval> res = new ArrayList<>();

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (int i = 1; i < intervals.size(); i++) {
            int nstart = intervals.get(i).start;
            int nend = intervals.get(i).end;

            //if not disjoint set
            if (end >= nstart) {
                end = Math.max(end, nend);
            } else {
                res.add(new Interval(start, end));
                start = nstart;
                end = nend;
            }
        }
        //add the last interval
        res.add(new Interval(start, end));
        return res;
    }

    public static List<Interval> merge2(List<Interval> intervals) {
        if(intervals == null || intervals.size() < 2)
            return intervals;
        List<Interval> res = new ArrayList<>();
        int len = intervals.size();
        int[] starts = new int[len], ends = new int[len];
        for(int i = 0; i < len; i++){
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        int start = starts[0], end = ends[0];
        for(int i = 0; i < len - 1; i++){
            if(ends[i] >= starts[i + 1]){
                end = ends[i + 1];
            }
            else{
                end = ends[i];
                res.add(new Interval(start, end));
                start = starts[i + 1];
                end = ends[i + 1];
            }
        }
        res.add(new Interval(start, end));
        return res;
    }


    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));
        System.out.println(merge2(intervals));
    }
}
