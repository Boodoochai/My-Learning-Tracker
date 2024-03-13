from collections import deque


def solve():
    n, m = map(int, input().split())
    l = [list(map(int, input().split())) + [n + 3] for i in range(m)]
    if m == 1:
        print('YES')
        return

    first = l[0][0]
    first_syf = l[0][1:]
    second = l[1][0]
    second_syf = l[1][1:]
    after_first = l[1][second_syf.index(first) + 2]
    after_second = l[0][first_syf.index(second) + 2]
    #print(after_second, after_first)
    fl = 0
    if after_second == after_first and m >= 3:
        for i in range(2, m):
            after_some = l[i][l[i].index(first) + 1]
            #print(after_some)
            if after_some != after_second:
                if after_some == second:
                    first_syf.insert(first_syf.index(after_some), first)
                else:
                    second_syf.insert(second_syf.index(first), second)
                    first_syf = second_syf.copy()
                fl = 1
                break
        if fl == 0:
            first_syf.insert(first_syf.index(after_first), first)
    else:
        first_syf.insert(first_syf.index(after_first), first)
    right_p = first_syf[:-1].copy()
    #print(right_p)
    for i in range(m):
        ind_1 = 0
        ind_2 = 1
        l[i] = l[i][:-1]
        while ind_1 < n and ind_2 < n:
            if right_p[ind_1] == l[i][0]:
                ind_1 += 1
            if right_p[ind_1] != l[i][ind_2]:
                print('NO')
                return
            ind_1 += 1
            ind_2 += 1
    print('YES')


def main():
    t = 1
    t = int(input())
    for i in range(t):
        solve()


if __name__ == '__main__':
    main()

'''
1
4 3
1 3 2 4
2 3 1 4
3 1 2 4

1
4 3
1 2 3 4
2 1 3 4
3 2 1 4


1
4 2
1 3 4 2
2 3 4 1


1
4 4
1 3 4 2
2 3 4 1
3 4 2 1
4 3 2 1

1
4 4
1 3 4 2
2 3 4 1
3 4 1 2
4 3 1 2
'''
