n = int(input())
l1 = list(map(int, input().split()))
l2 = list(map(int, input().split()))

flag = 0

actions = []

for i in range(n):
    ind = l1.index(l2[i])
    while ind != i:
        if abs(l1[ind] - l1[ind-1]) == 1:
            print(-1)
            exit()
        else:
            actions.append(ind)
            tmp = l1[ind]
            l1[ind] = l1[ind-1]
            l1[ind-1] = tmp
            ind -= 1

print(len(actions))
print(*actions)