from collections import deque

n = int(input())

gr = [int(input()) - 1 for _ in range(n)]

step = [0] * n

for i in range(n):
    step[gr[i]] += 1

topsort = []

nul = deque()

for i in range(n):
    if step[i] == 0:
        nul.append(i)

while nul:
    x = nul.popleft()
    topsort.append(x)
    step[gr[x]] -= 1
    if step[gr[x]] == 0:
        nul.append(gr[x])

for i in range(n):
    if step[i] != 0:
        topsort.append(i)

total_cyc = 0

for i in range(n):
    if step[i] != 0:
        x = i
        step[x] = 0
        while step[gr[x]] != 0:
            step[gr[x]] = 0
            x = gr[x]
            total_cyc += 1

ma = n - total_cyc

used = [0] * n
mi = 0
for x in topsort:
    if used[x] == 0:
        mi += 1
        r = x
        used[r] = 1
        while used[gr[r]] == 0:
            used[gr[r]] = 1
            r = gr[r]


print(mi, ma)
