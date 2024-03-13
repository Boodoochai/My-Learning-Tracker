def solve():
    n = int(input())
    ans = ''
    if n > 28:
        ans += 'z'
    else:
        ans += 1


def main():
    t = 1
    t = int(input())
    for i in range(t):
        solve()

if __name__ == '__main__':
    main()