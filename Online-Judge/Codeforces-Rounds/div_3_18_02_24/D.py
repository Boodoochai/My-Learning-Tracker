def solve():
    n = int(input())
    koz = input()
    l = list(input().split())

    n *= 2

    for i in range(n):
        l[i] = (int(l[i][0]), l[i][1])

    l.sort()
    
    used = set()

    ans = []

    for i in range(n):
        if l[i] in used:
            continue
        if l[i][1] != koz:
            for j in range(i + 1, n):
                if l[j] not in used:
                    if l[j][1] == l[i][1]:
                        used.add(l[j])
                        used.add(l[i])
                        ans.append((l[i], l[j]))
                        break

    for i in range(n):
        if l[i] in used:
            continue
        if l[i][1] == koz:
            continue
        for j in range(n):
            if l[j][1] == koz and l[i][1] != koz and l[j] not in used:
                used.add(l[j])
                used.add(l[i])
                ans.append((l[i], l[j]))
                break
            elif l[j][1] == koz and l[i][1] == koz and l[j] not in used and l[j][0] > l[i][0]:
                used.add(l[j])
                used.add(l[i])
                ans.append((l[i], l[j]))
                break

    for i in range(n):
        if l[i] in used:
            continue
        for j in range(n):
            if l[j][1] == koz and l[i][1] != koz and l[j] not in used:
                used.add(l[j])
                used.add(l[i])
                ans.append((l[i], l[j]))
                break
            elif l[j][1] == koz and l[i][1] == koz and l[j] not in used and l[j][0] > l[i][0]:
                used.add(l[j])
                used.add(l[i])
                ans.append((l[i], l[j]))
                break

    if len(ans) != n // 2:
        print('IMPOSSIBLE')
        return

    for x in ans:
        print(x[0][0], x[0][1], ' ', x[1][0], x[1][1], sep='')


def main():
    t = 1
    t = int(input())
    for _ in range(t):
        solve()


if __name__ == '__main__':
    main()
