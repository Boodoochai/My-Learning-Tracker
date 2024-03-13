package slidingwindowmaximum;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test void test1() {
        Solution classUnderTest = new Solution();
	int[] nums = {1,3,-1,-3,5,3,6,7};
	int k = 3;
	int[] ans = {3,3,5,5,6,7};
        assertArrayEquals(ans, classUnderTest.maxSlidingWindow(nums, k));
    }
    
    @Test void test2() {
        Solution classUnderTest = new Solution();
	int[] nums = {1};
	int k = 1;
	int[] ans = {1};
        assertArrayEquals(ans, classUnderTest.maxSlidingWindow(nums, k));
    }

    @Test void test3() {
        Solution classUnderTest = new Solution();
	int[] nums = {7, 6, 3, 5, -3, -1, 3, 1};
	int k = 3;
	int[] ans = {7, 6, 5, 5, 3, 3};
        assertArrayEquals(ans, classUnderTest.maxSlidingWindow(nums, k));
    }

    @Test void test4() {
        Solution classUnderTest = new Solution();
	int[] nums = {-7,-8,7,5,7,1,6,0};
	int k = 4;
	int[] ans = {7, 7, 7, 7, 7};
        assertArrayEquals(ans, classUnderTest.maxSlidingWindow(nums, k));
    }
}
