import sys


def is_in_alph2(k, x):
    g = ord(x) - ord('A')
    w = ord(x) - ord('0')
    if 0 <= g <= 25:
        g += 10
        if k - 1 >= g:
            return True
    if 0 <= w <= 9:
        if k - 1 >= w:
            return True
    return False


def is_in_alph(k, x):
    return x < k


def solve():
    s = sys.stdin.readlines()

    for i in range(len(s)):
        s[i] = list(s[i])
        for j in range(len(s[i])):
            if s[i][j] != '\n':
                s[i][j] = int(s[i][j], 36)
            else:
                s[i][j] = 40

    # s[-1] += '$'

    # letters = list('0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ')

    ma = 0
    ans_real = 2
    for i in range(2, 37):
        ans = 0
        for k in range(len(s)):
            for j in range(len(s[k])):
                if is_in_alph(i, s[k][j]) and not is_in_alph(i, s[k][j + 1]):
                    ans += 1
        if ans > ma:
            ma = ans
            ans_real = i

    print(ans_real, ma)


def main():
    t = 1
    # t = int(input())
    for _ in range(t):
        solve()


if __name__ == '__main__':
    main()
