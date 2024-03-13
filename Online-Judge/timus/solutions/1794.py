n = int(input())

l = list(map(int, input().split()))

dp = [0] * n

for i in range(n):
    dp[(i - l[i] + 1) % n] += 1

ma = max(dp)

for i in range(n):
    if dp[i] == ma:
        print(i + 1)
        break

'''
s = 0
st_ind = 0

for i in range(n * 3):
    if l[i % n] - 1 == l[(i - 1) % n]:
        s += 1
    else:
        st_ind = (i - s - l[(i - s) % n]+1) % n
        s = 0

print(st_ind + 1)
'''
