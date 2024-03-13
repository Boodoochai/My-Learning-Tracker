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
    s = list(input())[:-1]
    w = s + ['$'] + s[::-1]
    z = z_func(w)

    for i in range(len(s) + 1, len(w)):
        syf_len = len(w) - i
        if syf_len == z[i]:
            print(syf_len)
            return

    print(0)


def main():
    t = 1
    # t = int(input())
    for _ in range(t):
        solve()


if __name__ == '__main__':
    main()
