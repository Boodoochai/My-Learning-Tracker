from collections import deque

n, m = map(int, input().split())

gr = {i : set() for i in range(n)}

for i in range(n-1):
    a, b = map(int, input().split())
    a -= 1
    b -= 1
    gr[a].add(b)
    gr[b].add(a)

cities = list(map(int, input().split()))

if len(cities) == 1:
    print("YES")
    print(cities[0])
    exit()

for i in range(m):
    cities[i] -= 1
cities_set = set(cities)

que = deque()
que.append(cities[0])
used = set()
used.add(cities[0])

dist = [0] * (n)

node_found = 0
while len(que) > 0:
    x = que.popleft()
    for node in gr[x]:
        if node not in used:
            dist[node] = dist[x] + 1
            used.add(node)
            que.append(node)

ma = 0
ma_node = 0
for i in range(n):
    if dist[i] > ma and i in cities_set:
        ma = dist[i]
        ma_node = i

que = deque()
que.append(ma_node)
used = set()
used.add(ma_node)
parents = [-1] * n

dist = [0] * (n)

node_found = 0
while len(que) > 0:
    x = que.popleft()
    for node in gr[x]:
        if node not in used:
            dist[node] = dist[x] + 1
            used.add(node)
            parents[node] = x
            que.append(node)

ma = 0
ma_node_2 = 0
for i in range(n):
    if dist[i] > ma and i in cities_set:
        ma = dist[i]
        ma_node_2 = i


path = []

h = ma_node_2
while h != ma_node:
    path.append(parents[h])
    h = parents[h]
path = path[:-1]

if len(path) % 2 != 1:
    print("NO")
    exit()

middle = path[len(path) // 2]

que = deque()
que.append(middle)
used = set()
used.add(middle)

dist = [0] * n

while len(que) > 0:
    x = que.popleft()
    for node in gr[x]:
        if node not in used:
            used.add(node)
            dist[node] = dist[x] + 1
            que.append(node)

fl = 0

w = dist[cities[0]]

for x in cities:
    if dist[x] != w:
        fl = 1

if fl == 1:
    print("NO")
    exit()

print("YES")
print(middle+1)
