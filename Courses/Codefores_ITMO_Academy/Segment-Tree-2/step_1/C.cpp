#include <bits/stdc++.h>

using namespace std;

#define int long long

struct segtree
{
    vector<int> data;
    vector<int> set;
    int size;

    segtree(signed size)
    {
        this->data = vector<int>(size * 4, 0);
        this->set = vector<int>(size * 4, -1);
        this->size = size;
    }

    int get(int ind, int node, int l, int r)
    {
        if (l == r)
        {
            if (set[node] != -1)
            {
                return set[node];
            }
            else
            {
                return data[node];
            }
        }
        push_me(node);
        int m = (l + r) / 2;
        if (ind > m)
        {
            return get(ind, node * 2 + 1, m + 1, r);
        }
        else
        {
            return get(ind, node * 2, l, m);
        }
    }

    void push_me(int node)
    {
        if (set[node] == -1) {
            return;
        }
        data[node] = set[node];
        if (node * 2 < data.size())
        {
            set[node * 2] = set[node];
            set[node * 2 + 1] = set[node];
        }
        set[node] = -1;
    }

    void set_ravn(int val, int que_l, int que_r, int node, int l, int r)
    {
        if (que_l > que_r)
        {
            return;
        }
        if (que_l == l && que_r == r)
        {
            set[node] = val;
            return;
        }
        push_me(node);
        int m = (l + r) / 2;
        set_ravn(val, que_l, min(que_r, m), node * 2, l, m);
        set_ravn(val, max(m + 1, que_l), que_r, node * 2 + 1, m + 1, r);
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
            tree.set_ravn(v, l, r, 1, 1, tree.size);
        }
        if (t == 2)
        {
            int ind;
            cin >> ind;
            ind += 1;
            cout << tree.get(ind, 1, 1, tree.size) << endl;
        }
    }
}