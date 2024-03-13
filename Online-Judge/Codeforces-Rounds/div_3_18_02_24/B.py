def solve():
    n = int(input())
    l = list(map(int, input().split()))

    when = l.copy()

    for i in range(n):
        for j in range(i + 1, n):
            if when[j] <= when[i]:
                when[j] = when[i] // l[j] * l[j]
                if when[j] <= when[i]:
                    when[j] += l[j]

    print(max(when))


def main():
    t = 1
    t = int(input())
    for _ in range(t):
        solve()


if __name__ == '__main__':
    main()
