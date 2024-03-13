from collections import deque


def solve():
    n, m = map(int, input().split())
    l = list(map(int, input().split()))
    s = list(input())

    d = deque()

    for x in l:
        d.append(x)

    w = []

    for i in range(n):
        if s[i] == 'L':
            x = d.popleft()
        else:
            x = d.pop()
        w.append(x)

    w = w[::-1]
    ans = []

    prov = 1
    for i in range(n):
        prov *= w[i]
        prov %= m
        ans.append(prov)

    print(*ans[::-1])


def main():
    t = 1
    t = int(input())
    for _ in range(t):
        solve()


if __name__ == '__main__':
    main()
