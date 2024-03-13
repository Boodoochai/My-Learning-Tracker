n, k = map(int, input().split())

l = [0] * n

for i in range(k - 1):
    l[i] = i // 2 + 1
    if i % 2 == 1:
        l[i] *= -1

print(*l)
