package a1_array.interval;

import java.util.List;

import a0_common.Interval;

/**
 * Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.
 * 
 * For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:
 * 
 * [1, 1]
 * [1, 1], [3, 3]
 * [1, 1], [3, 3], [7, 7]
 * [1, 3], [7, 7]
 * [1, 3], [6, 7]
 * 
 * Follow up:
 * What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?
 * 
 * @author William
 *
 */
public class A352_DataStreamAsDisjointIntervals {
	class SummaryRanges {

	    /** Initialize your data structure here. */
	    public SummaryRanges() {
	        
	    }
	    
	    public void addNum(int val) {
	        
	    }
	    
	    public List<Interval> getIntervals() {
			return null;
	        
	    }
	}
	
	/**
	 * Your SummaryRanges object will be instantiated and called as such:
	 * SummaryRanges obj = new SummaryRanges();
	 * obj.addNum(val);
	 * List<Interval> param_2 = obj.getIntervals();
	 */
}
