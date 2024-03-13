import itertools


def solve(a, n, k):
    result = 1
    for group in itertools.groupby(a, key=lambda x: x == 1):
        if True in group[1]:
            group_size, = group[1]
            result *= (group_size - 1)
        else:
            break
    return result


t = int(input())

for i in range(t):
    e, n = map(int, input().split())
    a = list(map(int, input().split()))

    print(solve(a, n, e))