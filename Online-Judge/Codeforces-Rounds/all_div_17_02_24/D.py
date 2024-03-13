def count_t(l, r, a):
    ind = l
    ans = 0
    while ind < r:
        if a[ind] == 1:
            ans += 1
            ind += 2
        ind += 1

    return ans


def solve():
    n = int(input())
    a = list(map(int, input()))

    ans = 0

    for l in range(n):
        for r in range(l + 1, n+1):
            ans += count_t(l, r, a)

    print(ans)


def main():
    t = 1
    t = int(input())
    for _ in range(t):
        solve()


if __name__ == '__main__':
    main()
