def solve():
    n = int(input())
    l = list(input())
    for i in range(n):
        l[i] = int(l[i])

    ans = [0] * n

    carry_over = 0

    for i in range(n):
        ans[i] = carry_over + l[i]
        carry_over += l[i]

    ans.reverse()

    carry_over = 0
    for i in range(n):
        carry_over = ans[i] + carry_over
        ans[i] = carry_over % 10
        carry_over -= ans[i]
        carry_over //= 10

    ans.append(carry_over)

    while ans[-1] == 0:
        ans.pop()

    ans.reverse()
    print(*ans, sep='')

    '''
    l.reverse()

    x = 0
    w = 1
    for_one = 0
    for i in range(n):
        x += l[i] * for_one + l[i] * w
        w *= 10
        for_one = for_one * 10 + 1

    print(x)
    '''


def main():
    t = 1
    t = int(input())
    for _ in range(t):
        solve()


if __name__ == '__main__':
    main()
