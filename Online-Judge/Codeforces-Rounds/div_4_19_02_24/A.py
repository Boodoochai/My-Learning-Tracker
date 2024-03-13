def solve():
    n = int(input())
    l = [list(input()) for i in range(n)]
    for i in range(n):
        a = l[i]
        q = a.count('1')
        if q > 0:
            b = l[i + 1].count('1')
            if q != b:
                print('TRIANGLE')
            else:
                print('SQUARE')
            break


def main():
    t = 1
    t = int(input())
    for _ in range(t):
        solve()


if __name__ == '__main__':
    main()
