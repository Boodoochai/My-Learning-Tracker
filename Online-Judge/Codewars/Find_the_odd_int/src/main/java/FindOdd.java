import java.util.HashMap;
import java.util.Map;

public class FindOdd {
	public static int findIt(int[] a) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int x : a) {
			if (map.containsKey(x)) {
				map.put(x, map.get(x) + 1);
			} else {
				map.put(x, 1);
			}
		}
		for (int x : map.keySet()) {
			if (map.get(x) % 2 == 1) {
				return x;
			}
		}
		return -1;
	}
}
