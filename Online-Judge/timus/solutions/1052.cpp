#include <bits/stdc++.h>

using namespace std;


int main() {
    int n;
    cin >> n;

    vector<pair<int, int>> dots;
    for (int i = 0; i < n; i++) {
        int x, y;
        cin >> x >> y;
        dots.push_back({x, y});
    }

    int ans = 0;

    for (auto i: dots) {
        for (auto j: dots) {
            if (i == j) continue;
            pair<int, int> ab = {i.first - j.first, i.second - j.second};
            int s = 0;
            for (auto k: dots) {
                pair<int, int> bc = {j.first - k.first, j.second - k.second};
                int vec = ab.second * bc.first - ab.first * bc.second;
                if (vec == 0)
                    s += 1;
            ans = max(ans, s);
            }
        }
    }
    cout << ans;
}
