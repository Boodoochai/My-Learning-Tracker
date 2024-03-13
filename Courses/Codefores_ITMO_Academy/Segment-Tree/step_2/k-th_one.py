import sys

input = sys.stdin.readline
print = sys.stdout.write


# (summ, max_seg, pref, suf)

def build_tree(node, l, r):
    if l == r:
        do[node] = arr[l]
        return
    m = (l + r) // 2
    build_tree(node * 2, l, m)
    build_tree(node * 2 + 1, m + 1, r)
    left_child = do[node * 2]
    right_child = do[node * 2 + 1]
    do[node] = left_child + right_child


def update(node, l, r, ind):
    if l == r:
        do[node] = int(not do[node])
        return
    m = (l + r) // 2
    if ind <= m:
        update(node * 2, l, m, ind)
    else:
        update(node * 2 + 1, m + 1, r, ind)
    left_child = do[node * 2]
    right_child = do[node * 2 + 1]
    do[node] = left_child + right_child


def k_th_one(node, l, r, k):
    if l == r:
        return l
    m = (l + r) // 2
    if do[node * 2] >= k:
        return k_th_one(node * 2, l, m, k)
    return k_th_one(node * 2 + 1, m + 1, r, k - do[node * 2])


n, q = map(int, input().split())

arr = list(map(int, input().split()))

do = [0] * (n * 4)

build_tree(1, 0, n - 1)

for _ in range(q):
    x, y = map(int, input().split())
    if x == 1:
        update(1, 0, n - 1, y)
    if x == 2:
        print(str(k_th_one(1, 0, n - 1, y+1)) + '\n')
