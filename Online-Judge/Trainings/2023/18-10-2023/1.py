import math

mi = 1000000
for i in range(1, 10**4*2):
    f = math.pi * 2 * i
    diff = abs(f - int(f))
    diff = min(diff, 1 - diff)
    if diff < mi:
        mi = diff
        print(f, i, diff+1)