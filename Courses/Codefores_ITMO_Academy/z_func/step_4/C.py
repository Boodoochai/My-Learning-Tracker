import sys

input = sys.stdin.readline


def z_func(s):
    z = [0] * len(s)
    l = 0
    r = 0
    for i in range(1, len(s)):
        if i > r:
            while (z[i] + i < len(s)) and (s[z[i]] == s[z[i] + i]):
                z[i] += 1
            l = i
            r = z[i] + i - 1
        else:
            z[i] = min(z[i - l], r - i + 1)
            while (z[i] + i < len(s)) and (s[z[i]] == s[z[i] + i]):
                z[i] += 1
            if z[i] + i > r:
                l = i
                r = z[i] + i - 1

    z[0] = len(s)

    return z


def solve():
    s = list(input())[:-1]
    z = z_func(s)

    ans = [0] * (len(s) + 1)

    for i in range(len(s)):
        ans[z[i]] += 1

    for i in range(len(s) - 1, -1, -1):
        ans[i] = ans[i + 1] + ans[i]

    print(*ans[1:])


def main():
    t = 1
    t = int(input())
    for _ in range(t):
        solve()


if __name__ == '__main__':
    main()
