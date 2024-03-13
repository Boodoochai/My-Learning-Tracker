import sys
import math
import queue
import time
import random
input = sys.stdin.readline
# sys.stdin = open('arsenal.in')
# sys.stdout = open('arsenal.out', 'w')


def solve():
    a = list(map(int, input().split()))
    b = a[:8]
    a = a[8:]
    ans = [[1], [1], [100], [100]]
    while b or a:
        c = 0
        for e in range(2):
            f = 0
            for j in range(len(b)):
                for i in range(2):
                    if f or c == 2:
                        break
                    if ans[i][-1] - 10 == b[j]:
                        ans[i].append(b[j])
                        b = b[:j] + b[j + 1:]
                        c += 1
                        f = 1
                        break
                for i in range(2, 4):
                    if f or c == 2:
                        break
                    if ans[i][-1] + 10 == b[j]:
                        ans[i].append(b[j])
                        b = b[:j] + b[j + 1:]
                        c += 1
                        f = 1
                        break
            if c == 2:
                break
            ass = [10 ** 9, -1, -1]
            for o in range(len(b)):
                if 1 - f:
                    for j in range(4):
                        if j >= 2:
                            if b[o] < ans[j][-1] and ans[j][-1] - b[o] < ass[0]:
                                ass[0] = ans[j][-1] - b[o]
                                ass[1] = o
                                ass[2] = j
                        else:
                            if b[o] > ans[j][-1] and -ans[j][-1] + b[o] < ass[0]:
                                ass[0] = -ans[j][-1] + b[o]
                                ass[1] = o
                                ass[2] = j
            if ass[0] != 10 ** 9:
                ans[ass[2]].append(b[ass[1]])
                b = b[:ass[1]] + b[ass[1] + 1:]
                c += 1
        if c != 2:
            break
        b += a[:2]
        a = a[2:]
    print(*ans[0])
    print(*ans[1])
    print(*ans[2])
    print(*ans[3])
    print(*b)
    print(*a)


for _ in range(1):
    solve()
