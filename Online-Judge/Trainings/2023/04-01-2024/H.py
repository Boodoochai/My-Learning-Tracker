n = int(input())
time_in = list(map(int, input().split()))
num_out = list(map(int, input().split()))

if n < 3:
    print('impossible')
    exit()

for i in range(n):
    num_out[i] -= 1

for i in range(n):
    time_in[i] = (time_in[i], i)

time_in.sort()

pere = {}
for i in range(n):
    pere[time_in[i][1]] = i

real_num_out = [0] * n
for i in range(n):
    real_num_out[i] = pere[num_out[i]]

c = n - 2
for i in range(n - 2):
    if real_num_out[i] > real_num_out[i + 1]:
        c = i
        break

if c == n-2:
    if abs(real_num_out[n-2] - real_num_out[n-1]) == 1:
        print('impossible')
    else:
        print('end')
elif abs(real_num_out[c] - real_num_out[c + 1]) == 1:
    print('impossible')
elif real_num_out[c + 2] > real_num_out[c]:
    print('end')
else:
    print('begin')
