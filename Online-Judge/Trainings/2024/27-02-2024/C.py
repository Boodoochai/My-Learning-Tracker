import sys

input = sys.stdin.readline


def f(y, z):
    return (y * z * 2 + (y * (y - 1) // 2) + (z * (z-1)) // 2) % 3

def solve():
    print(f(0, 0))
    print(f(0, 1))
    print(f(0, 2))
    print(f(1, 0))
    print(f(1, 1))
    print(f(1, 2))
    print(f(2, 0))
    print(f(2, 1))
    print(f(2, 2))


def main():
    t = 1
    # t = int(input())
    for _ in range(t):
        solve()


if __name__ == '__main__':
    main()
