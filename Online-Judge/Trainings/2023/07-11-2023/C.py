n, m = map(int, input().split())

s = list(input())

colors = list(map(int, input().split()))

prev_with_color = [0] * (m + 1)

for i in range(n):
    if prev_with_color[colors[i]] == 0:
        prev_with_color[colors[i]] = s[i]
    else:
        tmp = prev_with_color[colors[i]]
        prev_with_color[colors[i]] = s[i]
        s[i] = tmp

fl = [0] * (m + 1)

for i in range(n):
    if fl[colors[i]] == 0:
        fl[colors[i]] = 1
        tmp = prev_with_color[colors[i]]
        prev_with_color[colors[i]] = s[i]
        s[i] = tmp

print(*s, sep='')
