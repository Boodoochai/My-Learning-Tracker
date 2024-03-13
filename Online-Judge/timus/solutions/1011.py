s = input().split()
if len(s) == 1:
    p = float(s)
    q = float(input())
else:
    p, q = map(float, s)

p = int(p * 100)
q = int(q * 100)

m = (p + q) // 2
for x in range(2, 10 ** 6):
    ko = int(x * m / 10000)
    if p < ko / x * 10000 < q:
        print(x)
        exit()
