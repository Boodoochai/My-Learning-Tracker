public class RotateQueue {
    public static void rotate(Queue que, int n) {
        if (que.size() == 0)
            return;
        for (int i = 0; i < (n % que.size()); i++) {
            que.enqueue(que.dequeue());
        }
    }
}
