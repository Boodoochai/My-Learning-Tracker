#include <bits/stdc++.h>

using namespace std;

int f(vector<int> l, vector<int> h, int n){
    int sh = 0;
    for (auto x : h) {
        sh += x;
    }
    if (sh == 0) {
        return 0;
    }

    int mi = 1 << 16;
    for (int i = 0; i < n; i++) {
        bool fl = 0;
        for (int j = 0; j < 3; j++) {
            if (h[(i + j) % n] == 1)
                fl = 1;
        }
        int a1 = h[i];
        int a2 = h[(i + 1) % n];
        int a3 = h[(i + 2) % n];
        if (!fl) continue;
        for (int j = 0; j < 3; j++)
            h[(i + j) % n] = 0;
        int s = 0;
        for (int t = 0; t < n; t++){
            if (h[t] == 1)
                s += l[t];
        }
        mi = min(s + f(l, h, n), mi);

        h[i] = a1;
        h[(i + 1) % n] = a2;
        h[(i + 2) % n] = a3;
    }

    return mi;
}

int main() {
    int n;
    cin >> n;
    vector<int> l(n, 0);
    
    for (int i = 0; i < n; i++) {
        cin >> l[i];
    }
    
    vector<int> h(n, 1);

    cout << f(l, h, n);
}