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
        q = len(s)
        s = s + [1000] + s[::-1]
        z = z_func(s)
        for j in range(q + 1, len(s)):
            syf_len = (len(s) - j)
            if syf_len == z[j]:
                print(syf_len)
                break

def main():
    t = 1
    # t = int(input())
    for _ in range(t):
        solve()


if __name__ == '__main__':
    main()
