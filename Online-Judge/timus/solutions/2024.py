def solve():
    s = list(map(lambda x: ord(x) - ord('a'), input()))
    x = int(input())

    a = [0] * 28

    h = 10 ** 3
    fact = [0] * h
    fact[0] = 1
    fact[1] = 1
    for i in range(2, h):
        fact[i] = fact[i - 1] * i

    for c in s:
        a[c] += 1

    a.sort(reverse=True)

    mi = a[x - 1]
    if mi == 0:
        print(sum(a), 1)
        return
    cur = a.count(mi)
    have = 0
    for i in range(x):
        if a[i] == mi:
            have += 1
    print(sum(a[:x]), fact[cur] // (fact[have] * (fact[cur - have])))


def main():
    t = 1
    # t = int(input())
    for _ in range(t):
        solve()


if __name__ == '__main__':
    main()
