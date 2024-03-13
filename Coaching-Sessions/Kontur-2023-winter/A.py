a, b = map(int, input().split())

if a == b:
    print(a * 3)
elif a > b:
    print(b * 3 + 1)
else:
    print(a * 3 + 2)