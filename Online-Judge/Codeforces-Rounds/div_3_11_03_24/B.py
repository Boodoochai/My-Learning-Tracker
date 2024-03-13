import sys

input = sys.stdin.readline


def solve():
    n = int(input())
    a = list(map(int, input().split()))

    for i in range(len(a) - 2):
        if a[i] < 0:
            print('NO')
            return
        a[i + 1] -= a[i] * 2
        a[i + 2] -= a[i]
        a[i] = 0

    if a[-1] != 0 or a[-2] != 0:
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
