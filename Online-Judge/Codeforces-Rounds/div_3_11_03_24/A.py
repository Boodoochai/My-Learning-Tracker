import sys
from collections import defaultdict

input = sys.stdin.readline


def solve():
    n, m, k = map(int, input().split())
    b = list(map(int, input().split()))
    c = list(map(int, input().split()))

    d = [0] * 2002
    for x in b:
        d[x] += 1

    for i in range(2001):
        d[i] += d[i-1]

    ans = 0
    for i in range(len(c)):
        if c[i] <= k:
            ans += d[min(len(d)-1, k-c[i])]

    print(ans)


def main():
    t = 1
    t = int(input())
    for _ in range(t):
        solve()


if __name__ == '__main__':
    main()
