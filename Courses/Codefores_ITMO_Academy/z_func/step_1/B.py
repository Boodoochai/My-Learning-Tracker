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
        s = list(map(lambda x: ord(x) - ord('a') + 1, input()[:-1]))
        num = 0
        for x in range(len(s)):
            for y in range(x, len(s)):
                fl = 1
                for j in range(x, y + 1):
                    if s[j] != s[j - x]:
                        fl = 0
                ffl = 1
                for j in range(y, x - 1, -1):
                    if s[j] != s[len(s) - (y - j) - 1]:
                        ffl = 0
                if (fl == 1 or ffl == 1) and (not (fl == 1 and ffl == 1)):
                    num += 1
        print(num)


def main():
    t = 1
    # t = int(input())
    for _ in range(t):
        solve()


if __name__ == '__main__':
    main()
