def solve():
    n = int(input())
    l = list(map(int, input().split()))

    dp = [[0] * 2 for _ in range(n)]
    dp[0][0] = l[0]
    dp[0][1] = 0

    for i in range(1, n):
        dp[i][0] = l[i]
        dp[i][0] = max(dp[i][0], dp[i - 1][1] + l[i])
        dp[i][1] = max(dp[i][1], dp[i - 1][0] - l[i])

    ma = 0
    for i in range(n):
        ma = max(ma, dp[i][0], dp[i][1])

    print(ma)


if __name__ == '__main__':
    solve()
