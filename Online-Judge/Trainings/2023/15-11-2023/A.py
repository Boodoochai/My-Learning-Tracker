bef = dict()
while True:
    s = input()
    if s == '------':
        break
    a, b, c = s.split()
    a = int(a)
    b = int(b)
    if c not in bef.keys():
        bef[c] = 0
    bef[c] += (b - a)

aft = dict()
for x in bef.keys():
    aft[x] = 0

while True:
    s = input()
    if s == '======':
        break
    a, b, c = s.split()
    a = int(a)
    b = int(b)
    if c not in aft.keys():
        aft[c] = 0
    aft[c] += (b - a)

for x in aft.keys():
    if x not in bef.keys():
        bef[x] = 0

ans = []
fl = 0
for x in bef.keys():
    if bef[x] != aft[x]:
        if bef[x] < aft[x]:
            ans.append(x + " +" + str(aft[x] - bef[x]))
        else:
            ans.append(x + " -" + str(bef[x] - aft[x]))
        fl = 1

if fl == 0:
    print("No differences found.")
else:
    ans.sort()
    print(*ans, sep='\n')
