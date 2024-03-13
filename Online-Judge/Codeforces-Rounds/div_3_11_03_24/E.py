import queue
import sys

input = sys.stdin.readline


def left_br(n, x, r):
    q = (x - r) % n
    return q


def right_br(n, x, r):
    q = (x + r) % n
    return q


def solve():
    n, m, k, d = map(int, input().split())
    l = [list(map(int, input().split())) for _ in range(n)]

    dp = [[0] * m for _ in range(m)]
    
    for i in range(n):
        dp[0] = [0, 0]
        for j in range(1, m-1):


def main():
    t = 1
    t = int(input())
    for _ in range(t):
        solve()


if __name__ == '__main__':
    main()
