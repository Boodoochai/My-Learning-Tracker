#include <bits/stdc++.h>

using namespace std;

struct seg_tree
{
    vector<int> data;

    void build(vector<int> &arr, int node, int l, int r)
    {
        if (l == r)
        {
            data[node] = arr[l];
            return;
        }
        int m = (l + r) / 2;
        build(arr, node * 2, l, m);
        build(arr, node * 2 + 1, m + 1, r);

        data[node] = data[node * 2] + data[node * 2 + 1];
    }

    void set(int ind, int val, int node, int l, int r)
    {
        if (l == r)
        {
            data[node] = val;
            return;
        }
        int m = (l + r) / 2;
        if (ind <= m)
        {
            set(ind, val, node * 2, l, m);
        }
        else
        {
            set(ind, val, node * 2 + 1, m + 1, r);
        }

        data[node] = data[node * 2] + data[node * 2 + 1];
    }

    int k_th_right_one(int k, int node, int l, int r)
    {
        if (l == r)
        {
            return l;
        }

        int m = (l + r) / 2;

        if (data[node * 2 + 1] >= k)
        {
            return k_th_right_one(k, node * 2 + 1, m + 1, r);
        }
        return k_th_right_one(k - data[node * 2 + 1], node * 2, l, m);
    }
};

int main()
{
    int n;
    cin >> n;

    vector<int> a(n);
    for (int i = 0; i < n; i++)
    {
        cin >> a[i];
    }

    vector<int> l(n, 1);
    seg_tree tr;
    tr.data = vector(n*4, 0);
    tr.build(l, 1, 0, n - 1);

    vector<int> ans(n, 0);

    for (int i = n - 1; i > -1; i--)
    {
        int ind = tr.k_th_right_one(a[i]+1, 1, 0, n - 1);
        ans[i] = ind + 1;
        tr.set(ind, 0, 1, 0, n - 1);
    }

    for (auto x : ans)
        cout << x << " ";
    cout << endl;
}
