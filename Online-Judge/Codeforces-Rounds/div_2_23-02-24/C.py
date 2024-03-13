def get_sum(pref_sum, l, r):
    q = pref_sum[r]
    if l > 0:
        q -= pref_sum[l - 1]
    return q


def solve():
    n, qu = map(int, input().split())
    l = list(map(int, input().split()))

    pref_sum = [0] * n
    pref_sum[0] = l[0]
    for i in range(1, n):
        pref_sum[i] = pref_sum[i - 1] + l[i]

    pref_ones = [0] * n
    if l[0] == 1:
        pref_ones[0] = 1
    for i in range(n):
        q = 0
        if l[i] == 1:
            q = 1
        pref_ones[i] = pref_ones[i - 1] + q

    for i in range(qu):
        x, y = map(int, input().split())
        x -= 1
        y -= 1
        su = get_sum(pref_sum, x, y)
        ones = get_sum(pref_ones, x, y)
        le = (y - x) + 1

        if su < le + ones or le == 1:
            print('NO')
        else:
            print('YES')


def main():
    t = 1
    t = int(input())
    for _ in range(t):
        solve()


if __name__ == '__main__':
    main()
