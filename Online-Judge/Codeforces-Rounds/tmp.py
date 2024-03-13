import sys
input = sys.stdin.readline
print = sys.stdout.write
st = [[1, 1]]
mod1 = 10 ** 9 + 7
mod2 = 10 ** 9 + 9
n = int(input())
ac = input()
a = list(ac)
b = list(input())
prefa = [[0, 0]]
prefb = [[0, 0]]
for i in range(n):
    prefa.append([(prefa[-1][0] * 27 + ord(a[i]) - 64) % mod1, (prefa[-1][1] * 27 + ord(a[i]) - 64) % mod2])
    prefb.append([(prefb[-1][0] * 27 + ord(b[i]) - 64) % mod1, (prefb[-1][1] * 27 + ord(b[i]) - 64) % mod2])
    st.append([st[-1][0] * 27 % mod1, st[-1][1] * 27 % mod2])
l = - 1
r = n
o = 0
while r - l > 1:
    m = (l + r) // 2
    s = set()
    s1 = set()
    f = True
    for i in range(m, n):
        s.add((prefa[i + 1][0] - (prefa[i - m][0] * st[m + 1][0] % mod1)) % mod1)
        s1.add((prefa[i + 1][1] - (prefa[i - m][1] * st[m + 1][1] % mod2)) % mod2)
    for i in range(m, n):
        if (prefb[i + 1][0] - (prefb[i - m][0] * st[m + 1][0] % mod1)) % mod1 in s and (
                prefb[i + 1][1] - (prefb[i - m][1] * st[m + 1][1] % mod2)) % mod2 in s1:
            l = m
            o = i
            f = False
            break
    if f:
        r = m
print(ac[o-l+1:o+2])
