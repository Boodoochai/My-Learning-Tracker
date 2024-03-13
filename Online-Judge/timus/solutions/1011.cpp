#include <bits/stdc++.h>

using namespace std;


int main() {
    double q1, p1;
    cin >> q1 >> p1;

    double q = p1;
    double p = q1;

    p += 1e-10;
    q -= 1e-10;

    for (int x = 1; x < 1e7; x++){
        if (int(x * q / 100) != int(x*p / 100)){
            cout << x << endl;
            return 0;
        }
    }
}
