n = int(input())
l = list(input())

s = set(l)

if len(s) % 2 == 0:
    print('First')
else:
    print('Second')
