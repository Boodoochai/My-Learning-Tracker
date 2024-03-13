import random
from math import gcd

eps = 10 ** (-7)


def check(n, a):
    a = sorted(a)
    for i in range(n):
        for j in range(i, n):
            b = [a[i], a[j]]
            c = []
            for o in range(n):
                if o == i or o == j:
                    continue
                if a[o] - b[-1] == b[1] - b[0]:
                    b.append(a[o])
                else:
                    c.append(a[o])
            if i == j:
                b = b[1:]
            if len(c) == 0:
                c.append(b.pop())
                return 9
            if len(c) == 1:
                return 9
            if c[0] == 0:
                if sum(c) == 0:
                    return 9
            else:
                d = gcd(c[1], c[0])
                k = (c[1] // d, c[0] // d)
                for o in range(2, len(c)):
                    d = gcd(c[o], c[o - 1])
                    if (c[o] // d, c[o - 1] // d) != k:
                        break
                else:
                    return 9
    return -1


def is_geo(x):
    if len(x) == 1:
        return True
    if 0 in x:
        return False
    if len(x) < 3:
        return True
    diff = x[1] / x[0]
    if diff == 0:
        return False
    for i in range(len(x) - 1):
        if abs(x[i + 1] / x[i] - diff) > eps:
            return False
    return True


def is_geo2(c):
    if len(c) == 1:
        return True
    if c[0] == 0:
        if sum(c) == 0:
            return True
        else:
            return False
    d = gcd(c[0], c[1])
    k = (c[1] // d, c[0] // d)
    f = 1
    for i in range(2, len(c)):
        d = gcd(c[i], c[i - 1])
        if k != (c[i] // d, c[i - 1] // d):
            f = 0
            break
    if f and (c[0] or sum(c) == 0):
        return True
    return False


def is_are(x):
    if len(x) < 3:
        return True
    diff = x[1] - x[0]
    for i in range(len(x) - 1):
        if x[i + 1] - x[i] != diff:
            return False
    return True


def solve(n, l):
    n = n
    l = sorted(l)

    if n == 2:
        return (1, [l[0]], [l[1]])

    if n == 3:
        return (2, [max(l[0], l[1]), min(l[0], l[1])], [l[2]])

    if n == 4:
        return (2, [max(l[0], l[1]), min(l[0], l[1])], [min(l[2], l[3]), min(l[2], l[3])])

    are = [l[1], l[2]]
    second = [l[0]]
    are_next = l[2] - l[1] + l[2]
    are_diff = l[2] - l[1]
    cur = 3
    while cur < n:
        while cur < n and are_next != l[cur]:
            second.append(l[cur])
            cur += 1
        if cur == n:
            break
        are.append(are_next)
        are_next += are_diff
        cur += 1

    if is_geo(second):
        ans = (len(are), are, second)
        return ans

    are = [l[0], l[2]]
    second = [l[1]]
    are_next = l[2] - l[0] + l[2]
    are_diff = l[2] - l[0]
    cur = 3
    while cur < n:
        while cur < n and are_next != l[cur]:
            second.append(l[cur])
            cur += 1
        if cur == n:
            break
        are.append(are_next)
        are_next += are_diff
        cur += 1

    if is_geo(second):
        ans = (len(are), are, second)
        return ans

    are = [l[0], l[1]]
    second = []
    are_next = l[1] - l[0] + l[1]
    are_diff = l[1] - l[0]
    cur = 2
    while cur < n:
        while cur < n and are_next != l[cur]:
            second.append(l[cur])
            cur += 1
        if cur == n:
            break
        are.append(are_next)
        are_next += are_diff
        cur += 1

    if is_geo(second):
        ans = (len(are), are, second)
        return ans

    are = [l[1], l[3]]
    second = [l[0], l[2]]
    are_next = l[3] - l[1] + l[3]
    are_diff = l[3] - l[1]
    cur = 4
    while cur < n:
        while cur < n and are_next != l[cur]:
            second.append(l[cur])
            cur += 1
        if cur == n:
            break
        are.append(are_next)
        are_next += are_diff
        cur += 1

    if is_geo(second):
        ans = (len(are), are, second)
        return ans

    are = [l[0], l[3]]
    second = [l[1], l[2]]
    are_next = l[3] - l[0] + l[3]
    are_diff = l[3] - l[0]
    cur = 4
    while cur < n:
        while cur < n and are_next != l[cur]:
            second.append(l[cur])
            cur += 1
        if cur == n:
            break
        are.append(are_next)
        are_next += are_diff
        cur += 1

    if is_geo(second):
        ans = (len(are), are, second)
        return ans

    are = [l[2], l[3]]
    second = [l[0], l[1]]
    are_next = l[3] - l[2] + l[3]
    are_diff = l[3] - l[2]
    cur = 4
    while cur < n:
        while cur < n and are_next != l[cur]:
            second.append(l[cur])
            cur += 1
        if cur == n:
            break
        are.append(are_next)
        are_next += are_diff
        cur += 1

    if is_geo(second):
        ans = (len(are), are, second)
        return ans

    # ---------------------------------------------------------------------------

    if l[1] != 0:
        geo_diff = l[2] / l[1]
        geo = [l[1], l[2]]
        second = [l[0]]

        are_next = l[2] * geo_diff
        if abs(are_next - int(are_next)) > eps:
            are_next = -1
        cur = 3
        while cur < n:
            while cur < n and are_next != l[cur]:
                second.append(l[cur])
                cur += 1
            if cur == n:
                break
            geo.append(are_next)
            are_next = are_next * geo_diff
            if abs(are_next - int(are_next)) > eps:
                are_next = -1
            cur += 1

        if is_are(second):
            ans = (len(second), second, geo)
            return ans

    if l[0] != 0:
        geo_diff = l[3] / l[0]
        geo = [l[0], l[3]]
        second = [l[1], l[2]]

        are_next = l[3] * geo_diff
        if abs(are_next - int(are_next)) > eps:
            are_next = -1
        cur = 4
        while cur < n:
            while cur < n and are_next != l[cur]:
                second.append(l[cur])
                cur += 1
            if cur == n:
                break
            geo.append(are_next)
            are_next = are_next * geo_diff
            if abs(are_next - int(are_next)) > eps:
                are_next = -1
            cur += 1

        if is_are(second):
            ans = (len(second), second, geo)
            return ans

    if l[0] != 0:

        geo_diff = l[1] / l[0]
        geo = [l[0], l[1]]
        second = []

        are_next = l[1] * geo_diff
        if abs(are_next - int(are_next)) > eps:
            are_next = -1
        cur = 2
        while cur < n:
            while cur < n and are_next != l[cur]:
                second.append(l[cur])
                cur += 1
            if cur == n:
                break
            geo.append(are_next)
            are_next = are_next * geo_diff
            if abs(are_next - int(are_next)) > eps:
                are_next = -1
            cur += 1

        if is_are(second):
            ans = (len(second), second, geo)
            return ans

    if l[0] != 0:
        geo_diff = l[2] / l[0]

        geo = [l[0], l[2]]
        second = [l[1]]
        are_next = l[2] * geo_diff
        if abs(are_next - int(are_next)) > eps:
            are_next = -1
        cur = 3
        while cur < n:
            while cur < n and are_next != l[cur]:
                second.append(l[cur])
                cur += 1
            if cur == n:
                break
            geo.append(are_next)
            are_next = are_next * geo_diff
            if abs(are_next - int(are_next)) > eps:
                are_next = -1
            cur += 1

        if is_are(second):
            ans = (len(second), second, geo)
            return ans

    if l[1] != 0:
        geo_diff = l[3] / l[1]
        geo = [l[1], l[3]]
        second = [l[0], l[2]]

        are_next = l[3] * geo_diff
        if abs(are_next - int(are_next)) > eps:
            are_next = -1
        cur = 4
        while cur < n:
            while cur < n and are_next != l[cur]:
                second.append(l[cur])
                cur += 1
            if cur == n:
                break
            geo.append(are_next)
            are_next = are_next * geo_diff
            if abs(are_next - int(are_next)) > eps:
                are_next = -1
            cur += 1

        if is_are(second):
            ans = (len(second), second, geo)
            return ans

    if l[2] != 0:
        geo_diff = l[3] / l[2]
        geo = [l[2], l[3]]
        second = [l[0], l[1]]

        are_next = l[3] * geo_diff
        if abs(are_next - int(are_next)) > eps:
            are_next = -1
        cur = 4
        while cur < n:
            while cur < n and are_next != l[cur]:
                second.append(l[cur])
                cur += 1
            if cur == n:
                break
            geo.append(are_next)
            are_next = are_next * geo_diff
            if abs(are_next - int(are_next)) > eps:
                are_next = -1
            cur += 1

        if is_are(second):
            ans = (len(second), second, geo)
            return ans
    return -1
    '''
    6
    2 4 8 1000 1001 16
    
    8
    0 0 0 0 0 0 9 10
    '''


def te():
    for i in range(10 ** 6):
        if i % 10 ** 3 == 1:
            print(i // 10 ** 3, '*' * 20)
        n1 = 500
        l1 = [random.randint(0, 10 ** 9) for _ in range(n1)]
        ans1 = solve(n1, l1.copy())
        fl = False
        if ans1 == -1:
            continue
        if len(ans1[1]) != ans1[0]:
            fl = True
        if len(ans1[1]) + len(ans1[2]) != n1:
            fl = True
        if (not is_are(ans1[1])) or (not is_geo(ans1[2])):
            fl = True
        if fl:
            print('-' * 40)
            print(n1)
            print(l1)
            print(ans1[0])
            print(ans1[1])
            print(ans1[2])


def main():
    n = int(input())

    l = sorted(list(map(int, input().split())))

    ans = solve(n, l)

    if ans == -1:
        print(-1)
    else:
        if ans[0] == 0 or ans[0] == n:
            print(1 / 0)
            return
        print(ans[0])
        print(*ans[1])
        print(*ans[2])


if __name__ == '__main__':
    te()

'''
10
3 0 6 8 10 5 7 0 4 9
0 0 3 4 5 6 7 8 9 10
'''
