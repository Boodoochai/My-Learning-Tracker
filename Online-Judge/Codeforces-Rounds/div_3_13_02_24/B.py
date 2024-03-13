def solve():
    n = int(input())
    l = list(map(int, input().split()))
    need = sum(l) // n
    have = 0
    for i in range(n):
        have -= max(0, need - l[i])
        if have < 0:
            print('NO')
            return
        have += max(0, l[i] - need)
    print('YES')


def main():
    t = 1
    t = int(input())
    for i in range(t):
        solve()


if __name__ == '__main__':
    main()
