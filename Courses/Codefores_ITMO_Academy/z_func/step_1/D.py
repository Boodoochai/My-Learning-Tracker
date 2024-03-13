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

    return z


def solve():
    n = int(input())
    for i in range(n):
        s = list(input()[:-1])
        t = list(input()[:-1])
        h = t + ['%'] + s
        z = z_func(h)

        num = 0
        for x in range(len(t) + 1, len(h)):
            for y in range(x, len(h)):
                fl = 1
                for j in range(x, y + 1):
                    syf_len = y - j + 1
                    if syf_len >= len(t) and z[j] >= len(t):
                        fl = 0
                        break
                num += fl
        print(num)


def main():
    t = 1
    # t = int(input())
    for _ in range(t):
        solve()


if __name__ == '__main__':
    main()
