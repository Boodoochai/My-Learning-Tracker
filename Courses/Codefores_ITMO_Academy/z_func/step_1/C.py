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


def solve():
    n = int(input())
    for i in range(n):
        s = list(input()[:-1])
        t = list(input()[:-1])
        num = 0
        ans = []
        for x in range(len(s) - len(t) + 1):
            fl = 1
            for j in range(x, x + len(t)):
                if (t[j - x] != s[j]) and (t[j - x] != '?'):
                    fl = 0
            if fl:
                num += 1
                ans.append(x)
        print(num)
        print(*ans)


def main():
    t = 1
    # t = int(input())
    for _ in range(t):
        solve()


if __name__ == '__main__':
    main()
