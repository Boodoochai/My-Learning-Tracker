#include <bits/stdc++.h>

using namespace std;

#define int long long

struct segtree
{

    vector<pair<int, int>> data;

    void build(int node, int l, int r, vector<int> &arr)
    {
        if (l == r)
        {
            data[node].first = arr[l];
            return;
        }
        int m = (l + r) / 2;
        build(node * 2, l, m, arr);
        build(node * 2 + 1, m + 1, r, arr);
        data[node].first = data[node * 2].first + data[node * 2 + 1].first;
    }

    int get(int node, int l, int r, int ind)
    {
        if (l == r)
        {
            return data[node].first + data[node].second;
        }
        int m = (l + r) / 2;
        if (ind <= m)
        {
            return get(node * 2, l, m, ind) + data[node].second;
        }
        else
        {
            return get(node * 2 + 1, m + 1, r, ind) + data[node].second;
        }
    }

    void add(int node, int l, int r, int que_l, int que_r, int val)
    {
        if (que_l > que_r)
        {
            return;
        }
        if (l == que_l && r == que_r)
        {
            data[node].second += val;
            return;
        }
        int m = (l + r) / 2;
        add(node * 2, l, m, que_l, min(m, que_r), val);
        add(node * 2 + 1, m + 1, r, max(m + 1, que_l), que_r, val);
    }
};

signed main()
{

    int n, m;
    cin >> n >> m;

    segtree tree;
    tree.data = vector<pair<int, int>>(n * 4, {0, 0});

    for (int i = 0; i < m; i++)
    {
        int q;
        cin >> q;
        if (q == 1)
        {
            int l, r, u;
            cin >> l >> r >> u;
            tree.add(1, 0, n - 1, l, r - 1, u);
            /*
            for (int j = 0; j < n; j++)
            {
                cout << tree.get(1, 0, n - 1, j);
            }
            cout << endl;
            */
        }
        else
        {
            int x;
            cin >> x;
            cout << tree.get(1, 0, n - 1, x) << endl;
        }
    }
}