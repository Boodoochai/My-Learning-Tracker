n = int(input())

dots = [list(map(int, input().split())) for _ in range(n)]

ans = 0

for i in dots:
    for j in dots:
        if i == j:
            continue
        ab = (i[0] - j[0], i[1] - j[1])
        s = 0
        for k in dots:
            bc = (j[0] - k[0], j[1] - k[1])
            vec = ab[1] * bc[0] - ab[0] * bc[1]
            if abs(vec) < 1e-7:
                s += 1
        ans = max(ans, s)

print(ans)
