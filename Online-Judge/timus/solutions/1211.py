import sys

input = sys.stdin.readline


def solve():
    n = int(input())
    l = list(map(int, input().split()))
    if l.count(0) != 1:
        print('NO')
        return

    for i in range(n):
        if l[i] == 0:
            l[i] = -2
        else:
            l[i] -= 1

    used = [-1] * n
    for i in range(n):
        if l[i] == -2:
            continue
        if used[i] == -1:
            cur = i
            while used[cur] == -1:
                if l[cur] == -2:
                    break
                used[i] = i
                cur = l[cur]
            if used[cur] == i:
                print('NO')
                return
    print('YES')


def main():
    t = 1
    t = int(input())
    for _ in range(t):
        solve()


if __name__ == '__main__':
    main()
