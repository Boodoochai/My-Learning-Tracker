from collections import defaultdict
from queue import PriorityQueue

inf = 10 ** 10


def dei(fr):
    he = PriorityQueue()
    dist = {(i, j): inf for i in range(n) for j in range(m)}
    parent = {(i, j): (-1, -1) for i in range(n) for j in range(m)}

    dist[fr] = l[fr[0]][fr[1]]
    parent[fr] = -1

    for x in gr[fr]:
        he.put((x[0] + dist[fr], x[1], fr))

    while not he.empty():
        x = he.get()
        if dist[x[1]] == inf:
            dist[x[1]] = x[0]
            parent[x[1]] = x[2]
            for node in gr[x[1]]:
                he.put((x[0] + node[0], node[1], x[1]))

    return dist, parent


n, m = map(int, input().split())

l = [list(map(int, input().split())) for _ in range(n)]

gr: dict[tuple, set] = defaultdict(set)

for x in range(n):
    for y in range(m):
        '''
        if x > 0:
            gr[(x, y)].add((l[x - 1][y], (x - 1, y)))
        '''
        if x < n - 1:
            gr[(x, y)].add((l[x + 1][y], (x + 1, y)))
        if y > 0:
            gr[(x, y)].add((l[x][y - 1], (x, y - 1)))
        if y < m - 1:
            gr[(x, y)].add((l[x][y + 1], (x, y + 1)))

mi = inf
ans = []
for i in range(m):
    gr[(-1, -1)].add((l[0][i], (0, i)))

dist, parent = dei((-1, -1))

mi_ind = -1
mi = 999999999999999999999
for i in range(m):
    if mi > dist[(n - 1, i)]:
        mi = dist[(n - 1, i)]
        mi_ind = i

cur = (n - 1, mi_ind)
ans = []
while cur != (-1, -1):
    ans.append(cur[1] + 1)
    cur = parent[cur]

print(*ans[::-1])

'''
n, m = map(int, input().split())

l = [list(map(int, input().split())) for _ in range(n)]

dp = [[0] * m for i in range(n)]

for i in range(m):
    dp[0][i] = l[0][i]

parent = [[0] * m for i in range(n)]

for i in range(1, n):
    for j in range(m):
        dp[i][j] = dp[i - 1][j] + l[i][j]
        parent[i][j] = (i-1, j)

    for j in range(m - 2, -1, -1):
        if dp[i][j + 1] + l[i][j] < dp[i - 1][j] + l[i][j]:
            dp[i][j] = dp[i][j + 1] + l[i][j]
            parent[i][j] = (i, j + 1)

    for j in range(1, m):
        if dp[i][j - 1] + l[i][j] < dp[i - 1][j] + l[i][j]:
            dp[i][j] = dp[i][j - 1] + l[i][j]
            parent[i][j] = (i, j - 1)

cur = parent[n - 1][dp[n - 1].index(min(dp[n - 1]))]
ans = []
while cur != 0:
    print(cur)
    ans.append(cur[1])
    cur = parent[cur[0]][cur[1]]

print(*cur[::-1])
'''
