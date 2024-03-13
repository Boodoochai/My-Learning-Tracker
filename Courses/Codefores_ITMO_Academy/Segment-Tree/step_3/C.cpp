#include <bits/stdc++.h>

using namespace std;

struct segtree
{

    vector<int> data;

    void build(int node, int l, int r, vector<int> &arr)
    {
        if (l == r)
        {
            data[node] = arr[l];
            return;
        }
        int m = (l + r) / 2;
        build(node * 2, l, m, arr);
        build(node * 2 + 1, m + 1, r, arr);
        data[node] = data[node * 2] + data[node * 2 + 1];
    }

    void set(int node, int l, int r, int ind, int val)
    {
        if (l == r)
        {
            data[node] = val;
            return;
        }
        int m = (l + r) / 2;
        if (ind <= m)
        {
            set(node * 2, l, m, ind, val);
        }
        else
        {
            set(node * 2 + 1, m + 1, r, ind, val);
        }
        data[node] = data[node * 2] + data[node * 2 + 1];
    }

    int sum_on_seg(int node, int l, int r, int que_l, int que_r)
    {
        if (que_l > que_r)
        {
            return 0;
        }
        if (l == que_l && r == que_r)
        {
            return data[node];
        }
        int m = (l + r) / 2;
        int left_child = sum_on_seg(node * 2, l, m, que_l, min(m, que_r));
        int right_child = sum_on_seg(node * 2 + 1, m + 1, r, max(m + 1, que_l), que_r);
        return left_child + right_child;
    }
};

int main()
{

    int n;
    cin >> n;
    n *= 2;
    vector<int> a(n);
    for (int i = 0; i < n; i++)
    {
        cin >> a[i];
    }

    segtree tree;
    tree.data = vector<int>(n * 4);

    vector<int> num(n, -1);

    vector<int> ans(n / 2, 0);

    for (int i = 0; i < n; i++)
    {
        /*
        for (auto x : tree.data) cout << x << " "; cout << endl;
        for (auto x : num) cout << x << " "; cout << endl;
        for (auto x : a) cout << x << " "; cout << endl;
        */
        if (num[a[i]] == -1)
        {
            num[a[i]] = i;
            // cout << a[i] << " " << i << endl;
            continue;
        }

        ans[a[i] - 1] = tree.sum_on_seg(1, 0, n - 1, num[a[i]], i);
        // cout << i << endl;
        tree.set(1, 0, n - 1, num[a[i]], 1);
    }

    for (auto x : ans)
        cout << x << " ";
    cout << endl;
}