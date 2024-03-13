from collections import defaultdict


def solve():
    n, m = map(int, input().split())
    l = list(map(int, input().split()))
    s = 0
    for x in l:
        s += len(str(x))

    for i in range(n):
        q = 0
        while l[i] % 10 == 0:
            q += 1
            l[i] //= 10
        l[i] = q

    l.sort(reverse=True)
    w = 0
    if 0 not in l:
        w -= l[-1]

    for i in range(0, n, 2):
        w += l[i]

    if s - w-1 < m:
        print('Anna')
    else:
        print('Sasha')

def main():
    t = 1
    t = int(input())
    for i in range(t):
        solve()


if __name__ == '__main__':
    main()
