import sys

input = sys.stdin.readline


def solve():
    n = int(input())
    s = input()[:-1]

    ans = s.count('pie') + s.count('map') - s.count('mapie')

    print(ans)


def main():
    t = 1
    t = int(input())
    for _ in range(t):
        solve()


if __name__ == '__main__':
    main()
