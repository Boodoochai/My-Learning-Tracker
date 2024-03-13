from collections import deque

n, m = map(int, input().split())

gr = [set() for i in range(n)]

step = [0] * n

for i in range(m):
    x, y, d, s = input().split()
    x = int(x) - 1
    y = int(y) - 1
    d = int(d)
    gr[x].add((x, y, d, s))
    step[y] += 1

nul = deque()
for i in range(n):
    if step[i] == 0:
        nul.append(i)

topsort = []
while nul:
    node = nul.popleft()
    topsort.append(node)
    for x in gr[node]:
        step[x[1]] -= 1
        if step[x[1]] == 0:
            nul.append(x[1])

dp = [[999999999999999] * 2 for i in range(n)]
dp[0][0] = 0
dp[0][1] = 0

for i in range(n):
    for x in gr[i]:
        if x[3] == 'Pirated':
            dp[x[1]][1] = min(dp[x[1]][1], dp[x[0]][1] + x[2], dp[x[0]][0] + x[2])
        elif x[3] == 'Licensed':
            dp[x[1]][0] = min(dp[x[1]][0], dp[x[0]][0] + x[2])
            dp[x[1]][1] = min(dp[x[1]][1], dp[x[0]][0] + x[2])
        elif x[3] == 'Cracked':
            dp[x[1]][0] = min(dp[x[1]][0], dp[x[0]][0] + x[2])
            dp[x[1]][1] = min(dp[x[1]][1], dp[x[0]][1] + x[2], dp[x[0]][0] + x[2])

s = min(dp[n - 1][0], dp[n - 1][1])
if s == 999999999999999:
    print('Offline')
else:
    print('Online')
    print(s)
