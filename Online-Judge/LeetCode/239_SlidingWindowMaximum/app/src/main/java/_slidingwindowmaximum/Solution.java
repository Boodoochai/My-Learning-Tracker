package slidingwindowmaximum;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Iterator;

public class Solution {
	public int[] maxSlidingWindow(int[] nums, int k) {
		Deque<Integer> deq = new LinkedList<Integer>();
		int[] maxes = new int[nums.length - k + 1];
		int cur_max = -999999;

		for (int i = 0; i < nums.length; i++){
			if (nums[i] >= cur_max) {
				cur_max = nums[i];
				deq = new LinkedList<Integer>();
				deq.addLast(nums[i]);
			} else {
				while (deq.getFirst() <= nums[i]) {
					deq.removeFirst();
				}
				deq.addLast(nums[i]);	
			}
		
			if (deq.size() > k && deq.getFirst() == cur_max) {
				Iterator<Integer> iter = deq.iterator();
				iter.next();
				cur_max = -99999;
				while (iter.hasNext()){
					cur_max = max(cur_max, iter.next());
				}
			}
			if (deq.size() > k) {
				deq.removeFirst();
			}

			if (i > k-2) {maxes[i-k+1] = cur_max;}
		}
		
		return maxes;
	}

	private int max(int a, int b) {
		if (a > b) { return a; }
		return b;
	}
}
