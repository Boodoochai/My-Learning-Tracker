def solve():
    n = int(input())
    l = [list(input().split())[1:] for _ in range(n)]

    for i in range(n):
        fl = 0
        for j in range(n):
            if i == j:
                continue
            if l[i][0] <= l[j][0] and l[i][-1] > l[j][-1]:
                fl = 1
            if l[i][0] >= l[j][0] and l[i][-1] < l[j][-1]:
                fl = 1

        if fl:
            print('NO')
            return

    print('YES')


def main():
    t = 1
    # t = int(input())
    for _ in range(t):
        solve()


if __name__ == '__main__':
    main()
