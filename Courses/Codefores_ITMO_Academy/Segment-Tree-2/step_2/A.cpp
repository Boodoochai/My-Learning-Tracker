#include <bits/stdc++.h>

using namespace std;

#define int long long

struct segtree
{
    vector<int> data;
    vector<int> added;
    int size;

    segtree(signed size)
    {
        this->data = vector<int>(size * 4, 0);
        this->added = vector<int>(size * 4, 0);
        this->size = size;
    }

    int get_min(int que_l, int que_r, int node, int l, int r)
    {
        if (que_l > que_r)
        {
            return 200000000000;
        }
        push_me(node);
        if (que_l == l && que_r == r)
        {
            return added[node] + data[node];
        }
        int m = (l + r) / 2;
        int left = get_min(que_l, min(que_r, m), node * 2, l, m);
        int right = get_min(max(m + 1, que_l), que_r, node * 2 + 1, m + 1, r);
        return min(left, right);
    }

    void push_me(int node)
    {
        data[node] += added[node];
        if (node * 2 < data.size())
        {
            added[node * 2] += added[node];
            added[node * 2 + 1] += added[node];
        }
        added[node] = 0;
    }

    void add(int val, int que_l, int que_r, int node, int l, int r)
    {
        if (que_l > que_r)
        {
            return;
        }
        push_me(node);
        if (que_l == l && que_r == r)
        {
            added[node] += val;
            return;
        }
        int m = (l + r) / 2;
        add(val, que_l, min(que_r, m), node * 2, l, m);
        add(val, max(m + 1, que_l), que_r, node * 2 + 1, m + 1, r);
    }
};

signed main()
{
    int n, m;
    cin >> n >> m;
    segtree tree(n);
    for (int i = 0; i < m; i++)
    {
        int t;
        cin >> t;
        if (t == 1)
        {
            int l, r, v;
            cin >> l >> r >> v;
            l += 1;
            tree.add(v, l, r, 1, 1, tree.size);
        }
        if (t == 2)
        {
            int l, r;
            cin >> l >> r;
            l += 1;
            cout << tree.get_min(l, r, 1, 1, tree.size) << endl;
        }
    }
}