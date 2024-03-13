import random

s1 = list(input())
s2 = list(input())

se1 = set()
se2 = set()

for i in range(10 ** 5 * 4):
    random.shuffle(s1)
    se1.add(tuple(s1))
    random.shuffle(s2)
    se2.add(tuple(s2))

for x in se1:
    if x in se2:
        print('equal')
        exit()

print('different')
