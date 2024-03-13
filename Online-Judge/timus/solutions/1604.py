n = int(input())
l = list(map(int, input().split()))

l = [[l[i], i + 1] for i in range(len(l))]

l.sort(reverse=True)

cur_ind = 0
ans = [0] * sum([l[i][0] for i in range(len(l))])

for i in range(0, len(ans), 2):
    if l[cur_ind][0] > 0:
        l[cur_ind][0] -= 1
        ans[i] = l[cur_ind][1]
    else:
        cur_ind += 1
        l[cur_ind][0] -= 1
        ans[i] = l[cur_ind][1]

if l[0][0] != 0:
    for i in range(len(ans) - len(ans) % 2 - 1, -1, -2):
        if l[cur_ind][0] > 0:
            l[cur_ind][0] -= 1
            ans[i] = l[cur_ind][1]
        else:
            cur_ind += 1
            l[cur_ind][0] -= 1
            ans[i] = l[cur_ind][1]
else:
    for i in range(1, len(ans), 2):
        if l[cur_ind][0] > 0:
            l[cur_ind][0] -= 1
            ans[i] = l[cur_ind][1]
        else:
            cur_ind += 1
            l[cur_ind][0] -= 1
            ans[i] = l[cur_ind][1]

print(*ans)
