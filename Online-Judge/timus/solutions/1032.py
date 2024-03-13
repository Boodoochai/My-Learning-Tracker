n = int(input())
l = [int(input()) for i in range(n)]

dp = [[0] * (n + 1) for i in range(n + 1)]

dp[0][0] = 1

for i in range(n):
    for j in range(n + 1):
        if dp[i][j] == 1:
            dp[i + 1][j] = 1
            dp[i + 1][(j + l[i]) % (n + 1)] = 1

if dp[n - 1][n] == 0:
    print(0)
else:
    ans = []
    k = n - 1
    s = n
    while k > 0:
        if dp[k - 1][(s - l[k]) % (n + 1)] == 1:
            ans.append(k + 1)
            s -= l[k]
            k -= 1
        else:
            k -= 1
    print(len(ans))
    print(*sorted(ans), sep='\n')
