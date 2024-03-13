import random
from math import sqrt


def f(x, y, circ):
    r = sqrt((x - circ[0]) ** 2 + (y - circ[1]) ** 2)
    if r > circ[2]:
        return False
    return True


n = int(input())

circ = [0] * n
for i in range(n):
    circ[i] = list(map(float, input().split()))

k = 0
for i in range(10 ** 6):
    x = random.random()
    y = random.random()
    fl = 0
    for j in range(n):
        if f(x, y, circ[j]):
            fl = 1
    k += fl

print(k / 10 ** 6 * 100)
