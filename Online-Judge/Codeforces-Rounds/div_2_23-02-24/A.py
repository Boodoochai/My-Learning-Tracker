def solve():
    n = int(input())
    l = list(map(int, input().split()))

    ind = 0
    while l[ind] != 1:
        ind += 1

    ind1 = n - 1
    while l[ind1] != 1:
        ind1 -= 1

    cur = 0
    for i in range(ind, ind1 + 1):
        if l[i] == 0:
            cur += 1

    print(cur)


def main():
    t = 1
    t = int(input())
    for _ in range(t):
        solve()


if __name__ == '__main__':
    main()
