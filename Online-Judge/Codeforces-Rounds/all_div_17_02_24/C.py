def solve():
    n = int(input())
    l = list(map(int, input().split()))

    for i in range(n):
        l[i] = l[i] + i + 1

    l.sort(reverse=True)

    s = set()

    for i in range(n):
        if l[i] not in s:
            s.add(l[i])
            

def main():
    t = 1
    t = int(input())
    for _ in range(t):
        solve()


if __name__ == '__main__':
    main()
