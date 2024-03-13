n, m = map(int, input().split())
x1, y1 = map(int, input().split())
x2, y2 = map(int, input().split())

dp = [[-1] * m for i in range(n)]
cur_x = 0
cur_y = 0
dvi = 0
'''
1 ->
2 down
3 <-
4 ^
'''
for i in range(n * m):
    dp[cur_x][cur_y] = i
    if dvi == 0:
        if cur_y + 1 >= m or dp[cur_x][cur_y + 1] != -1:
            dvi = (dvi + 1) % 4
    elif dvi == 1:
        if cur_x + 1 >= n or dp[cur_x + 1][cur_y] != -1:
            dvi = (dvi + 1) % 4
    elif dvi == 2:
        if cur_y - 1 < 0 or dp[cur_x][cur_y - 1] != -1:
            dvi = (dvi + 1) % 4
    else:
        if cur_x - 1 < 0 or dp[cur_x - 1][cur_y] != -1:
            dvi = (dvi + 1) % 4

    if dvi == 0:
        cur_y += 1
    elif dvi == 1:
        cur_x += 1
    elif dvi == 2:
        cur_y -= 1
    else:
        cur_x -= 1

print(abs(dp[x1 - 1][y1 - 1] - dp[x2 - 1][y2 - 1]))
