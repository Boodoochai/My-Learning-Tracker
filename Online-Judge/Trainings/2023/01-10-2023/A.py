import math


def is_prime(x):
    for i in range(2, int(math.sqrt(x)+1)):
        if x % i == 0:
            return False
    return True


def solve():
    e, n = map(int, input().split())
    a = list(map(int, input().split()))
    p = list()
    k = 0
    for j in range(1, e+1):
        for i in range(0, n, e):
            if a[i] == 1:
                k += 1
            else:
                p.append(k)
                k = 0



t = int(input())

for i in range(t):
    solve()