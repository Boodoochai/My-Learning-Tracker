n = int(input());
ans = 0;
l = len(str(n))
for i in range(1, 10):
    for j in range(1, 14):
        if int(str(i) * j) <= n:
            ans += 1;

ans += l - 1
if l == 1: ans += 1

print(ans);