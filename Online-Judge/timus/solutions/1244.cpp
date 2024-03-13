#include <bits/stdc++.h>

using namespace std;


int main() {

    int n, m;
    cin >> m >> n;

    vector<int> l(n, 0);
    for (int i = 0; i < n; i++) {
        cin >> l[i];
    }

    int mas_full = 0;
    for (int i = 0; i < n; i++) {
        mas_full += l[i];
    }
    

    int mas_diff = mas_full - m;

    vector<vector<int>> dp;
    for (int i = 0; i < n+1; i++) {
        vector<int> q(mas_diff +1, 0);
        dp.push_back(q);
    }

    dp[0][0] = 1;

    for (int i = 0; i < n; i++)
        for (int j = 0; j < mas_diff+1; j++){
            if (dp[i][j] != 0){
                dp[i + 1][j] += dp[i][j];
                if (j + l[i] <= mas_diff)
                    dp[i + 1][j + l[i]] += dp[i][j];
            }
        }


    if (dp[n][mas_diff] == 0) {
        cout << 0 << endl;
    } else if (dp[n][mas_diff] > 1) {
        cout << -1 << endl;
    } else {
        int k = n;
        vector<int> ans;
        int cur_mas = mas_diff;
        while (k > 0){
            if (cur_mas - l[k - 1] >= 0 && dp[k - 1][cur_mas - l[k - 1]] > 0) {
                ans.push_back(k);
                cur_mas -= l[k-1];
                k -= 1;
            }
            else{
                k -= 1;
            }
        }
        sort(ans.begin(), ans.end());
        for (int i = 0; i < ans.size(); i++) cout << ans[i] << ' ';
        cout << endl;
    }
}