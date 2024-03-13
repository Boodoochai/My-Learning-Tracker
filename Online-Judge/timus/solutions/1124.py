from collections import defaultdict


def dfs(x):
    used[x] = 1
    for node in gr[x]:
        if not used[node]:
            dfs(node)


m, n = map(int, input().split())

gr = defaultdict(set)

cou = 0

couu = 0
for i in range(m):
    l = list(map(int, input().split()))
    fl = 0
    for x in l:
        if x - 1 != i:
            fl = 1
            cou += 1
            gr[i].add(x - 1)
    if fl == 0:
        couu += 1

used = [0] * m
co = 0
for i in range(m):
    if not used[i]:
        dfs(i)
        co += 1

if co - couu == 0:
    print(0)
else:
    print(cou + (co - couu - 1))
