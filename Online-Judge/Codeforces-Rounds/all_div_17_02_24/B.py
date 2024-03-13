def solve():
    n = int(input())

    l = [0] * (n + 1)

    if n % 2 == 0:
        for i in range(0, n, 2):
            l[i] = i + 1
            l[i + 1] = n - i

    if n % 2 == 1:
        for i in range(0, n - 1, 2):
            l[i] = i + 1
            l[i + 1] = n - i - 1
        l[n - 1] = n

    print(*l[:n])


def main():
    t = 1
    t = int(input())
    for _ in range(t):
        solve()


if __name__ == '__main__':
    main()
