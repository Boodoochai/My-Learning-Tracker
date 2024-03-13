def solve():
    n, k = map(int, input().split())
    groups = [n // 2 + n % 2]
    c = 2
    while n // c > 0:
        x = (n // c)
        if x % 2 == 0:
            x -= 1
        x -= x // 2
        groups.append(x)
        c *= 2

    s = 0
    for i in range(len(groups)):
        if s + groups[i] >= k:
            c = 2 ** i
            print(c * ((k - s) * 2 - 1))
            return
        s += groups[i]


def main():
    t = 1
    t = int(input())
    for _ in range(t):
        solve()


if __name__ == '__main__':
    main()
