m = int(input())

n = int(input())

l = [int(input()) for i in range(n)]

mas_full = sum(l)

mas_diff = mas_full - m

dp = [[0] * (mas_diff + 1) for _ in range(n + 1)]

dp[0][0] = 1

for i in range(n):
    for j in range(mas_diff + 1):
        if dp[i][j] != 0:
            dp[i + 1][j] += dp[i][j]
            if j + l[i] <= mas_diff:
                dp[i + 1][j + l[i]] += dp[i][j]

if dp[n][mas_diff] == 0:
    print(0)
elif dp[n][mas_diff] > 1:
    print(-1)
else:
    k = n
    ans = []
    cur_mas = mas_diff
    while k > 0:
        if cur_mas - l[k - 1] >= 0 and dp[k - 1][cur_mas - l[k - 1]] > 0:
            ans.append(k)
            cur_mas -= l[k-1]
            k -= 1
        else:
            k -= 1
    print(*sorted(ans))
