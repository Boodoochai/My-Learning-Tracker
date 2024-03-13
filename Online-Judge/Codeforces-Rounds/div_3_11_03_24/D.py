import sys

input = sys.stdin.readline


def left_br(n, x, r):
    q = (x - r) % n
    return q


def right_br(n, x, r):
    q = (x + r) % n
    return q


def solve():
    n, m, x = map(int, input().split())
    x -= 1
    ans = set()
    ans.add(x)
    for i in range(m):
        a, b = input().split()
        a = int(a)
        to_add = set()
        if b == '0':
            for w in ans:
                to_add.add(right_br(n, w, a))
        elif b == '1':
            for w in ans:
                to_add.add(left_br(n, w, a))
        elif b == '?':
            for w in ans:
                to_add.add(right_br(n, w, a))
                to_add.add(left_br(n, w, a))
        ans = to_add

    print(len(ans))
    print(*sorted(map(lambda x: x + 1, ans)))


def main():
    t = 1
    t = int(input())
    for _ in range(t):
        solve()


if __name__ == '__main__':
    main()
