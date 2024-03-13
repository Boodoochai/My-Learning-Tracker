n = int(input())

s = list(input())

q = int(input())

time = [0] * (n+1)

first_t = [0] * (q+1)
second_t = [0] * (q+1)

last_t = 0

for i in range(q):
    t, x, c = input().split()
    t = int(t)
    x = int(x)
    if t == 1:
        s[x-1] = c
        time[x-1] = i+1
    elif t == 2:
        first_t[i+1] = 1
        last_t = 1
    elif t == 3:
        second_t[i+1] = 1
        last_t = 2

syf_sym_first = [0] * (q+1)
syf_sym_first[q] = first_t[q]

for i in range(q-1, -1, -1):
    syf_sym_first[i] = syf_sym_first[i+1] + first_t[i]


syf_sym_second = [0] * (q+1)
syf_sym_second[q] = second_t[q]

for i in range(q-1, -1, -1):
    syf_sym_second[i] = syf_sym_second[i+1] + second_t[i]


for i in range(n):
    cur = ''
    t_1 = syf_sym_first[time[i]]
    t_2 = syf_sym_second[time[i]]
    if s[i].islower():
        if t_2 > 0 and t_1 == 0:
            cur = s[i].upper()
        elif t_2 == 0:
            cur = s[i].lower()
        else:
            if last_t == 2:
                cur = s[i].upper()
            else:
                cur = s[i].lower()
    if s[i].isupper():
        if t_1 > 0 and t_2 == 0:
            cur = s[i].lower()
        elif t_1 == 0:
            cur = s[i].upper()
        else:
            if last_t == 2:
                cur = s[i].upper()
            else:
                cur = s[i].lower()
    print(cur, end='')