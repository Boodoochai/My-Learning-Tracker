#include <bits/stdc++.h>

#define inf 1000000007

using namespace std;

int get_hash(int x, int y)
{
    return x * 1000 + y;
}

vector<vector<int>> l;
map<int, vector<pair<int, int>>> gr;

pair<map<int, int>, map<int, int>> dei(int fr)
{
    multimap<int, pair<int, int>> he;
    map<int, int> dist;
    map<int, int> parent;
    // dist = {(i, j): inf for i in range(n) for j in range(m)}
    // parent = {(i, j): (-1, -1) for i in range(n) for j in range(m)}

    for (auto x : gr) {
        dist[x.first] = inf;
    }
    dist[fr] = 0;
    parent[fr] = -1;


    for (auto x : gr[fr]) {
        he.insert({x.first + dist[fr],  {x.second, fr}});
    }

    while (!he.empty()){
        pair<int, pair<int, int>> x = *(he.begin());
        he.erase(he.begin());
        if (dist[x.second.first] == inf){
            dist[x.second.first] = x.first;
            parent[x.second.first] = x.second.second;
            for (auto node : gr[x.second.first]){
                he.insert({x.first + node.first, {node.second, x.second.first}});
            }
        }
    }
    return make_pair(dist, parent);
}

signed main()
{
    int n, m;
    cin >> n >> m;

    for (int i = 0; i < n; i++)
    {
        vector<int> a(m, 0);
        l.push_back(a);
        for (int j = 0; j < m; j++)
        {
            cin >> l[i][j];
        }
    }

    for (int x = 0; x < n; x++)
    {
        for (int y = 0; y < m; y++)
        {
            if (x < n - 1)
            {
                gr[get_hash(x, y)].push_back({l[x + 1][y], get_hash(x + 1, y)});
            }
            if (y > 0)
            {
                gr[get_hash(x, y)].push_back({l[x][y - 1], get_hash(x, y - 1)});
            }
            if (y < m - 1)
            {
                gr[get_hash(x, y)].push_back({l[x][y + 1], get_hash(x, y + 1)});
            }
        }
    }

    int mi = inf;

    for (int i = 0; i < m; i++)
    {
        gr[get_hash(500, 500)].push_back({l[0][i], get_hash(0, i)});
    }

    pair<map<int, int>, map<int, int>> dis_par = dei(get_hash(500, 500));

    int mi_ind = -1;
    mi = inf;
    for (int i = 0; i < m; i++)
    {
        if (mi > dis_par.first[get_hash(n - 1, i)])
        {
            mi = dis_par.first[get_hash(n - 1, i)];
            mi_ind = i;
        }
    }

    int cur = get_hash(n - 1, mi_ind);
    vector<int> ans;

    while (cur != (-1, -1))
    {
        ans.push_back(cur % 1000 + 1);
        cur = dis_par.second[cur];
    }

    for (int i = ans.size()-2; i > -1; i--)
    {
        cout << ans[i] << " ";
    }
}