ans = [0] * (2 * 10 ** 5 + 1)
for i in range(1, 2 * 10 ** 5 + 1):
    ans[i] = ans[i - 1] + sum(list(map(lambda x: ord(x) - ord('0'), str(i))))


def solve():
    n = int(input())

    print(ans[n])


def main():
    t = 1
    t = int(input())
    for _ in range(t):
        solve()


if __name__ == '__main__':
    main()
