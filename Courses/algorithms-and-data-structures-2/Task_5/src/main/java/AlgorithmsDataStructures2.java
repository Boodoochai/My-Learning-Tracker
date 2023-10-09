import java.util.Arrays;

public class AlgorithmsDataStructures2 {
    public static int[] GenerateBBSTArray(int[] a) {
        Arrays.sort(a);
        int[] tree = new int[a.length*2];
        GenerateBBSTArrayRec(a, 0, a.length, tree, 0);
        return tree;
    }

    private static void GenerateBBSTArrayRec(int[] a, int l, int r, int[] tree, int tree_ind) {
        if (l == r) {
            return;
        }
        int m = (l+r) / 2;
        tree[tree_ind] = a[m];
        GenerateBBSTArrayRec(a, l, m, tree, tree_ind*2+1);
        GenerateBBSTArrayRec(a, m+1, r, tree, tree_ind*2+2);
    }
}