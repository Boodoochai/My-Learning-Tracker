def is_win(m, j):
    if m == 23:
        return True
    if m < 23 < j:
        return True
    return False


n = int(input())
john = list(map(int, input().split()))
marry = list(map(int, input().split()))
common = list(map(int, input().split()))

cards = {i: 0 for i in range(1, 14)}

for x in john + marry + common:
    cards[x] += 1

common_sum = 0
for x in common:
    common_sum += min(10, x)

marry_sum = 0
for x in marry:
    marry_sum += min(10, x)
marry_sum += common_sum

john_sum = 0
for x in john:
    john_sum += min(10, x)
john_sum += common_sum

ans = -1

for i in range(1, 14):
    if cards[i] < 4 and is_win(marry_sum + min(i, 10), john_sum + min(i, 10)):
        ans = min(i, 10)
        break

print(ans)
