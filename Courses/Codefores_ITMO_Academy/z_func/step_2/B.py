import sys

input = sys.stdin.readline


def z_func(s):
    z = [0] * len(s)
    l = 0
    r = 0
    for i in range(1, len(s)):
        if i > r:
            while z[i] + i < len(s) and s[z[i] + i] == s[z[i]]:
                z[i] += 1
            l = i
            r = i + z[i] - 1
        else:
            z[i] = min(z[i - l], r - i + 1)
            while z[i] + i < len(s) and s[z[i] + i] == s[z[i]]:
                z[i] += 1

    z[0] = len(s)
    return z


def get_gray(k, j):
    le = 2 ** (k - 1)

    if k == 1:
        return 1

    if j == le:
        return 0
    elif j < le:
        return get_gray(k - 1, j - k - 1)
    else:

def solve():
    n = int(input())
    for i in range(n):
        k, j = map(int, input().split())
        print(get_gray(k, j))

def main():
    t = 1
    # t = int(input())
    for _ in range(t):
        solve()


if __name__ == '__main__':
    main()
