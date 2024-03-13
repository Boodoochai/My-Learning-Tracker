n, m = map(int, input().split())
l = list(map(int, input().split()))

dp = [0] * (n + 1)
dp[0] = 1
for i in range(1, n + 1):
    for k in l:
        if i - k >= 0 and dp[i - k] == 0:
            dp[i] = 1
            break

if dp[n]:
    print(1)
else:
    print(2)

'''
10000 5
12 144 1000 500 1
'''
