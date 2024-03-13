from collections import deque


def solve():
    n = int(input())
    l = list(map(int, input().split()))
    l.sort()
    d = deque()
    for i in range(n):
        d.append(l[i])

    ans = 0

    cur_comb = 0

    while d:
        if len(d) == 1:
            x = d.pop()
            if x == 1:
                ans += 1
            else:
                ans += x // 2 + x % 2
                ans += 1
        else:
            y = d.pop()
            x = d.popleft()
            s = x
            while len(d) > 0 and s < y:
                x = d.popleft()
                s += x

            if s > y:
                d.appendleft(s - y)
                ans += y + 1
            elif s == y:
                ans += y + 1
            else:
                q = y - s
                ans += s + 1
                if q == 1:
                    ans += 1
                else:
                    ans += q // 2 + q % 2
                    if s == 0:
                        ans += 1

    print(ans)


def main():
    t = 1
    t = int(input())
    for _ in range(t):
        solve()


if __name__ == '__main__':
    main()
