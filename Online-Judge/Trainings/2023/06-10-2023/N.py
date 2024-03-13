a1, b1 = map(int, input().split(':'))
a2, b2 = map(int, input().split(':'))

# min_mi = min(b2-b1 + a2-a1, 60 - b1 + b2 - 1 + a2-a1, 60 - b1 + b2 - 1 + 24 - a1 + a2, 24 - a1 + a2 + abs(b2-b1))

m1 = a1*60+b1
m2 = a2*60 + b2

d = m2-m1
if d < 0:
    d += 23*60+60

print(d // 60 + d % 60)
