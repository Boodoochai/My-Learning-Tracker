def f(s: str):
    for i in range(200):
        s = s.replace("AA", "")
        s = s.replace("BB", "")
        s = s.replace("CC", "")
        s = s.replace("BAB", "A")
        s = s.replace("BCB", "C")
        s = s.replace("ABA", "B")
        s = s.replace("CBC", "B")
    b = s.count("B")
    s = s.replace("B", "")
    if b % 2 == 1:
        s += "B"
    return s


t = int(input())

for i in range(t):
    a = input()
    b = input()
    a = f(a)
    b = f(b)
    if a == b:
        print("YES")
    else:
        print("NO")
