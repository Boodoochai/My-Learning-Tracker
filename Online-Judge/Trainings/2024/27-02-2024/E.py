import sys
from collections import defaultdict

input = sys.stdin.readline


def f(y, z):
    return (y * z * 2 + (y * (y - 1) // 2) + (z * (z-1)) // 2) % 3


def solve():
    n = int(input())
    l = list(map(int, input().split()))
    for i in range(n):
        l[i] %= 3

    d = defaultdict(int)

    y = 0
    z = 0

    ans = 0

    for i in range(n):
        if l[i] == 1:
            y += 1
        elif l[i] == 2:
            z += 1

        ans += d[((y % 3) % 3, (z % 3) % 3)]
        ans += d[((y % 3) % 3, (z % 3 - 1) % 3)]
        ans += d[((y % 3 - 1) % 3, (z % 3) % 3)]
        #ans += d[((y % 3 - 1) % 3, (z % 3 - 2) % 3)]

        if f(y, z) == 0:
            ans += 1

        d[(y % 3, z % 3)] += 1

    print(ans)


def main():
    t = 1
    # t = int(input())
    for _ in range(t):
        solve()


if __name__ == '__main__':
    main()
