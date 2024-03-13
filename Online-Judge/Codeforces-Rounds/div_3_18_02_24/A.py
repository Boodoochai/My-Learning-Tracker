def solve():
    n = int(input())
    l = list(input())

    ans = 0
    if l[0] == '@':
        ans += 1
    for i in range(n - 1):
        if l[i + 1] == '@':
            ans += 1
        if l[i] == '*' and l[i + 1] == '*':
            break

    print(ans)


def main():
    t = 1
    t = int(input())
    for _ in range(t):
        solve()


if __name__ == '__main__':
    main()
