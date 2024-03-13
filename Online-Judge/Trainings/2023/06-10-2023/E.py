def is_possible_1(i, j):
    if (j == 0 or matr[i][j - 1] != '.') and (i == n - 1 or matr[i + 1][j] != '.'):
        return True
    return False

def is_possible_2(i, j):
    if (j == n-1 or matr[i][j + 1] != '.') and (i == n - 1 or matr[i + 1][j] != '.'):
        return True
    return False

def is_possible_3(i, j):
    if (j == 0 or matr[i][j - 1] != '.') and (i == 0 or matr[i - 1][j] != '.'):
        return True
    return False

def is_possible_4(i, j):
    if (j == n-1 or matr[i][j + 1] != '.') and (i == 0 or matr[i - 1][j] != '.'):
        return True
    return False

n = int(input())
matr = [list(input()) for i in range(n)]

dp = [[[0] * 5 for j in range(n)] for i in range(n)]
dp[0][0][1] = 1
dp[0][0][2] = 1
dp[0][0][3] = 1
dp[0][0][4] = 1
# 1  |_
# 2   _|
#      _
# 3   |
#      _
# 4     |

for i in range(n):
    for j in range(n):
        if is_possible_1(i, j):
            if j > 0:
                dp[i][j][1] += dp[i][j-1][3] + dp[i][j-1][1]
            if i > 0:
                dp[i][j][1] += dp[i-1][j][1] + dp[i-1][j][2] + dp[i-1][j][3] + dp[i-1][j][4]
        if is_possible_2(i, j):
            if j > 0:
                dp[i][j][2] += dp[i][j - 1][1] + dp[i][j - 1][2] + dp[i][j - 1][3] + dp[i][j - 1][4]
            if i > 0:
                dp[i][j][2] += dp[i - 1][j][1] + dp[i - 1][j][2] + dp[i - 1][j][3] + dp[i - 1][j][4]
        if is_possible_3(i, j):
            if j > 0:
                dp[i][j][3] += dp[i][j - 1][1] + dp[i][j - 1][3]
            if i > 0:
                dp[i][j][3] += dp[i - 1][j][3] + dp[i - 1][j][4]
        if is_possible_4(i, j):
            if j > 0:
                dp[i][j][4] += dp[i][j - 1][1] + dp[i][j - 1][2] + dp[i][j - 1][3] + dp[i][j - 1][4]
            if i > 0:
                dp[i][j][4] += dp[i - 1][j][3] + dp[i - 1][j][4]

print(dp)
