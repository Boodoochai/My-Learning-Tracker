n = int(input())

commands = [set(input().split()) for _ in range(n)]

gr = [set() for i in range(n)]

for i in range(n):
    for j in range(i + 1, n):
        if len(commands[i].intersection(commands[j])) > 0:
            gr[i].add(j)
            gr[j].add(i)

ans = 0

for i in range(2 ** n):
    k = 0
    coms = []
    while i > 0:
        if i & 1:
            coms.append(k)
        k += 1
        i >>= 1

    fl = 0
    for o in range(len(coms)):
        for j in range(o+1, len(coms)):
            if coms[j] in gr[coms[o]]:
                fl = 1

    if fl == 0:
        ans = max(ans, len(coms))

print(ans)

'''
ans = 0

for i in range(2 ** n):
    s = set()
    k = 0
    fl = 0
    su = 0
    while i > 0:
        if i & 1 == 1:
            su += 1
            for x in commands[k]:
                if x in s:
                    fl = 1
                    break
                else:
                    s.add(x)
            if fl == 1:
                break
        i >>= 1
        k += 1
    if fl == 0:
        ans = max(ans, su)

print(ans)
'''
