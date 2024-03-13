def solve():
    n, k = map(int, input().split())
    health = list(map(int, input().split()))
    cords = list(map(lambda x: abs(int(x)), input().split()))

    monstr = [[cords[i], health[i]] for i in range(n)]
    monstr.sort()

    sme = 0
    dop_dm = 0
    for i in range(n):
        monstr[i][0] -= sme
        if dop_dm > monstr[i][1]:
            dop_dm -= monstr[i][1]
            monstr[i][1] = 0
        else:
            monstr[i][1] -= dop_dm
            dop_dm = 0
        need = monstr[i][1] // k
        if monstr[i][1] % k > 0:
            need += 1
        if monstr[i][0] < need:
            print('NO')
            return
        sme += need
        dop_dm += need * k - monstr[i][1]

    print('YES')


def main():
    t = 1
    t = int(input())
    for _ in range(t):
        solve()


if __name__ == '__main__':
    main()
