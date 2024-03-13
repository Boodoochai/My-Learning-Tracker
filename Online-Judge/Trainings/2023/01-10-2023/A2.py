import math


def is_prime(x):
    for i in range(2, int(math.sqrt(x) + 1)):
        if x % i == 0:
            return False
    return True


def solve():
    n, e = map(int, input().split())
    a = list(map(int, input().split()))

    ans = 0
    for i in range(n):
        g = a[i]
        r = 1
        if e*r+1 < n and is_prime(g):
            ans -= 1
        while e*r+1 < n and is_prime(g):
            ans += 1
            g *= a[r*e+1]
            r += 1

    print(ans)

t = int(input())

for i in range(t):
    solve()