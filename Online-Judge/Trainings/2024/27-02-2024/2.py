T, N, K, L, r, rn, i, j = 0, 0, 0, 0, 0, 0, 0, 0
M = 0
a = [0] * 11111
z = [0] * 33333
b = [0] * 11111

for i in range(1, 11112):
    r = 3 * i
    rn = 0
    while r != 0:
        rn += (r % 10) ** 2
        r //= 10
    a[i] = rn // 3

T = int(input())
for i in range(1, T + 1):
    N, K, L = map(int, input().split())
    r = K // 3
    b = [0] * 11111
    for j in range(1, N):
        z[j] = r
        b[r] = j
        if b[a[r]] != 0:
            r = z[(N - 1 - b[a[r]]) % (j - b[a[r]] + 1) + b[a[r]]]
            print(3 * r - L)
            break
        r = a[r]
        if j == N - 1:
            print(3 * r - L)
