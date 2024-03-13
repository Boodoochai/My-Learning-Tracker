# https://timus.online/problem.aspx?space=1&num=1102

'''
one
in
input
puton
out
output
'''


def f(dp, s):
    if s[:3] == 'one':
        dp[2] = 'one'
    if s[:3] == 'out':
        dp[2] = 'out'
    if s[:5] == 'input':
        dp[4] = 'input'
    if s[:5] == 'puton':
        dp[4] = 'puton'
    if s[:6] == 'output':
        dp[5] = 'output'

def f1(dp, s, ind):
    if dp[ind-1] == 'one':
        dp[]

def solve():
    s = input() + '-' * 10
    dp = [0] * len(s)
    f(dp, s)
    for i in range(3, len(s)):
        f1(dp, s, i)

    print(dp[len(s)-1])

def main():
    t = int(input())
    for i in range(t):
        solve()


if __name__ == '__main__':
    main()
