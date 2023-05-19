public class FindOddOptimized {
	public static int findIt(int[] a) {
		int xor = 0;
		for (int x : a) {
			xor ^= x;
		}
		return xor;
	}
}
