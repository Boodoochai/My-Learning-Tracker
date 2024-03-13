#include <bits/stdc++.h>

using namespace std;

int main() {
    int n;
    scanf("%d", &n);

    int mass[100005];
     memset((mass), 0, sizeof(mass));

    for(int i = 0; i <= n; i++) {
        int a, b, c;
        scanf("%d%d%d", &a, &b, &c);
        mass[a] += c;
        mass[b + 1] -= c;
    }

    for(int i = 1; i < 100005; i++) {
        mass[i] += mass[i - 1];
    }

    for(int i = 1; i <= n; i++) {
        printf("%d ", mass[i]);
    }
}