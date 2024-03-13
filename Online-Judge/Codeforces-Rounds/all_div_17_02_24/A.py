def solve():
    n = int(input())
    l = list(map(int, input().split()))

    l.sort()

    ans = 0

    for i in range(0, n * 2, 2):
        ans += l[i]

    print(ans)


def main():
    t = 1
    t = int(input())
    for _ in range(t):
        solve()


if __name__ == '__main__':
    main()
