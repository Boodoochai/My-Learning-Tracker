def solve():
    n, k = map(int, input().split())

    if n < k:
        print(0)
        return

    for i in range(n):

    print((n * n - min(n % k, k - n % k)) // k)


def main():
    t = 1
    # t = int(input())
    for _ in range(t):
        solve()


if __name__ == '__main__':
    main()
