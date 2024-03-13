#include<bits/stdc++.h>

using namespace std;

struct seg_tree {
    vector<int> data = vector<int>();

    void build(vector<int> arr) {
        data.resize(arr.size()*4);
    }

    void set(int node, int l, int r, int ind, int val) {
        if (l == r) {
            data[node] = val;
            return;
        }
        int m = (l + r) / 2;
        if (ind <= m) {
            set(node*2, l, m, ind, val);
        } else {
            set(node*2+1, m+1, r, ind, val);
        }
        data[node] = data[node*2] + data[node*2+1];
    }

    int sum_on_range(int node, int l, int r, int que_l, int que_r) {
        if (que_l > que_r) {
            return 0;
        }
        if (l == que_l && r == que_r) {
            return data[node];
        }
        int m = (l + r) / 2;
        int left_child = sum_on_range(node*2, l, m, que_l, min(m, que_r));
        int right_child = sum_on_range(node*2+1, m+1, r, max(que_l, m+1), que_r);
        return left_child + right_child;
    }
};

int main() {
    int n;
    cin >> n;
    vector<int> l(n, 0);
    seg_tree tr;
    tr.build(l);

    int ans;
    for (int i = 0; i < n; i++) {
        int a;
        cin >> a;
        //cout << a << endl;
        a--;
        cout << tr.sum_on_range(1, 0, n-1, a, n-1) << ' ';
        tr.set(1, 0, n-1, a, 1);
    }
    cout << endl;
}
