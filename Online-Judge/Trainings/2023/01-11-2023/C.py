def f(gr, node):
    for x in gr[node]:
        f(gr, x)
    

n = int(input())

l = list(map(int, input().split()))

gr = {i+1: set() for i in range(n)}

for i in range(len(l)):
    gr[i+2].add(l[i])
    gr[l[i]].add(i+2)

f(gr, 1)
