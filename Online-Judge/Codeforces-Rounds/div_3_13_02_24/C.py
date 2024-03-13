from collections import defaultdict


def solve():
    n, x, y = map(int, input().split())
    l = list(map(int, input().split()))
    d = defaultdict(dict)
    d[l[0] % x][l[0] % y] = 1
    ans = 0
    for a in l[1:]:
        #print(a, a % x, a % y, x - a % x, x, y)
        if a % y in d[(x - (a % x)) %x].keys():
            ans += d[(x - (a % x)) %x][a % y]
        if a % y not in d[a % x].keys():
            d[a % x][a % y] = 0
        d[a % x][a % y] += 1

    #print(d)
    print(ans)


def main():
    t = 1
    t = int(input())
    for i in range(t):
        solve()


if __name__ == '__main__':
    main()
