public class PalindromChecker {
    public static boolean isPalindrom(String str) {
        Deque<Character> deq = new Deque<Character>();
        for (char c : str.toCharArray())
            deq.addFront(c);

        while (deq.size() > 1) {
            if (deq.removeFront() != deq.removeTail()) {
                return false;
            }
        }
        return true;
    }
}
