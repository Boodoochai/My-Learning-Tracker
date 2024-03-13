from collections import defaultdict


def solve():
    n = int(input())
    l = list(map(int, input().split()))
    to_xor = 2 ** 31 - 1
    cou = 0
    s = defaultdict(int)
    for i in range(n):
        q = to_xor ^ l[i]
        if s[q] > 0:
            s[q] -= 1
            cou += 1
        else:
            s[l[i]] += 1

    print(n - cou)


def main():
    t = 1
    t = int(input())
    for _ in range(t):
        solve()


if __name__ == '__main__':
    main()
