#include <bits/stdc++.h>

using namespace std;

int main(){

    int t;
    cin >> t;

    for (int i = 0; i < t; i++) {
        int n;
        cin >> n;
        char first = 'a' - 1 + min(26, n - 2);
        n -= min(26, n - 2);
        char second = 'a' - 1 + min(26, n - 1);
        n -= min(26, n - 1);
        char third = 'a' - 1 + n;
        cout << third << second << first << '\n';
    }

}