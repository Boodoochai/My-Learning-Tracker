#include <bits/stdc++.h>
using namespace std;

#define int long long

int mod = 1000000000 + 7;

struct segtree
{
    vector<int> data;
    vector<int> multed;
    int size;

    segtree(signed size)
    {
        this->data = vector<int>(size * 4, 1);
        this->multed = vector<int>(size * 4, 1);
        this->size = size;
    }

    int get_sum(int que_l, int que_r, int node, int l, int r)
    {
        if (que_l > que_r)
        {
            return 0;
        }
        push_me(node);
        if (que_l == l && que_r == r)
        {
            return data[node] % mod;
        }
        int m = (l + r) / 2;
        int left = get_sum(que_l, min(que_r, m), node * 2, l, m);
        int right = get_sum(max(m + 1, que_l), que_r, node * 2 + 1, m + 1, r);
        return (left + right) % mod;
    }

    void push_me(int node)
    {
        if (node * 2 < data.size())
        {
            data[node * 2] *= multed[node];
            data[node * 2] %= mod;
            multed[node * 2] *= multed[node];
            multed[node * 2] %= mod;
            data[node * 2 + 1] *= multed[node];
            data[node * 2 + 1] %= mod;
            multed[node * 2 + 1] *= multed[node];
            multed[node * 2 + 1] %= mod;
        }
        multed[node] = 1;
    }

    void mult(int val, int que_l, int que_r, int node, int l, int r)
    {
        if (que_l > que_r)
        {
            return;
        }
        push_me(node);
        if (que_l == l && que_r == r)
        {
            multed[node] *= val;
            multed[node] %= mod;
            data[node] *= val;
            data[node] %= mod;
            return;
        }
        int m = (l + r) / 2;
        mult(val, que_l, min(que_r, m), node * 2, l, m);
        mult(val, max(m + 1, que_l), que_r, node * 2 + 1, m + 1, r);
        data[node] = (data[node * 2] + data[node * 2 + 1]) % mod;
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
            tree.mult(v, l, r, 1, 1, tree.size);
        }
        if (t == 2)
        {
            int l, r;
            cin >> l >> r;
            l += 1;
            cout << tree.get_sum(l, r, 1, 1, tree.size) << " " << endl;
        }
    }
}