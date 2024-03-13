n = int(input())

teams = []

for i in range(n):
    l = list(input().split())
    c = l[0]
    p = int(l[1])
    l = l[2:]
    l = list(map(int, l))
    l.sort()
    l = l[1:]
    l = l[:-1]
    score = p * 10 + sum(l)
    teams.append((score, c))

teams.sort(reverse=True, key=lambda x: x[0])

first_score = teams[0][0]
high_count = 0
high_count_2 = 0
second_score = -1
third_score = -1


for i in range(n):
    if first_score == teams[i][0]:
        high_count += 1
        print(*teams[i][::-1])
    elif high_count <= 2 and (second_score == -1 or second_score == teams[i][0]):
        second_score = teams[i][0]
        high_count_2 += 1
        print(*teams[i][::-1])
    elif high_count + high_count_2 <= 2 and (third_score == -1 or third_score == teams[i][0]):
        third_score = teams[i][0]
        print(*teams[i][::-1])
    else:
        break
