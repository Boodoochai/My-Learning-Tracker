import sys
from collections import defaultdict

sys.setrecursionlimit(10 ** 5 * 5)


def dfs(tree, node, used, type):
    used.add(node)
    ans = 0
    cou_c = 0
    cou_s = 0
    cou_p = 0
    cou_r = 0
    for x in tree[node]:
        if x not in used:
            a, t = dfs(tree, x, used, type)
            ans += a
            if t == 'S':
                cou_s += 1
            elif t == 'C':
                cou_c += 1
            elif t == 'P':
                cou_p += 1
            elif t == 'R':
                cou_r += 1

    if type[node] == 'C':
        if cou_s == cou_p:
            return ans + cou_s, 'R'
        if cou_s > cou_p:
            return ans + cou_p, 'S'
        if cou_s < cou_p:
            return ans + cou_s, 'P'
    elif type[node] == 'S':
        return ans + cou_p, 'S'
    elif type[node] == 'P':
        return ans + cou_s, 'P'


def solve():
    n = int(input())
    tree = defaultdict(set)
    l = list(map(int, input().split()))
    for i in range(n - 1):
        tree[l[i] - 1].add(i + 1)
        tree[i + 1].add(l[i] - 1)
    type = list(input())

    print(dfs(tree, 0, set(), type)[0])


def main():
    t = 1
    t = int(input())
    for _ in range(t):
        solve()


if __name__ == '__main__':
    main()
