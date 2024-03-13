a1 = int(input())
a2 = int(input())
a3 = int(input())
a4 = int(input())

b = int(input())

if (a1==a2==a3==a4):
    print(1)
elif (a1==a2==a3+b==a4):
    print(1)
elif (a1==a2+b==a3==a4):
    print(1)
elif (a1==a2==a3==a4+b):
    print(1)
elif (a1+b==a2==a3==a4):
    print(1)
else:
    print(0)
