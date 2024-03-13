def f(x):
    w = x * a
    w -= x * x
    return w


def f1(x):
    w = x * b
    w -= x * x
    return w


a, b = map(float, input().split())
n = int(input())
s = 0
ans1 = 0
ans2 = 0
s22 = 0
ans22 = 0
for i in range(n, -1, -1):
    s1 = f(i)
    s2 = f1(n - i)
    if s2 > s22:
        s22 = s2
        ans22 = n - i
    if s1 + s22 >= s :
        s = s1 + s22
        ans1 = i
        ans2 = ans22

print(round(s, 2))
print(ans1, ans2)
