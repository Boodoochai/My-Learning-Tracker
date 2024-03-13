def solve():
    n = int(input())
    if n * 6 > 100000:
        print('TOO LONG')
        return

    if n == 1:
        print('a')
        print('b')
        print('c')
        return

    print('abc' * (n // 3) + 'abc'[:n % 3])
    print('acb' * (n // 3) + 'acb'[:n % 3])
    print('bac' * (n // 3) + 'bac'[:n % 3])
    print('bca' * (n // 3) + 'bca'[:n % 3])
    print('cab' * (n // 3) + 'cab'[:n % 3])
    print('cba' * (n // 3) + 'cba'[:n % 3])


def main():
    t = 1
    # t = int(input())
    for _ in range(t):
        solve()


if __name__ == '__main__':
    main()
