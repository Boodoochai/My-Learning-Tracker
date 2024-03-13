import sys

input = sys.stdin.readline
print = sys.stdout.write


# (summ, max_seg, pref, suf)

def build_tree(node, l, r):
    if l == r:
        if arr[l] < 0:
            do[node] = (arr[l], 0, 0, 0)
            return
        do[node] = (arr[l], arr[l], arr[l], arr[l])
        return
    m = (l + r) // 2
    build_tree(node * 2, l, m)
    build_tree(node * 2 + 1, m + 1, r)
    left_child = do[node * 2]
    right_child = do[node * 2 + 1]
    do[node] = (left_child[0] + right_child[0],
                max(left_child[3] + right_child[2], left_child[1], right_child[1]),
                max(left_child[2], left_child[0] + right_child[2]),
                max(right_child[3], right_child[0] + left_child[3]))


def update(node, l, r, ind, val):
    if l == r:
        if val < 0:
            do[node] = (val, 0, 0, 0)
            return
        do[node] = (val, val, val, val)
        return
    m = (l + r) // 2
    if ind <= m:
        update(node * 2, l, m, ind, val)
    else:
        update(node * 2 + 1, m + 1, r, ind, val)
    left_child = do[node * 2]
    right_child = do[node * 2 + 1]
    do[node] = (left_child[0] + right_child[0],
                max(left_child[3] + right_child[2], left_child[1], right_child[1]),
                max(left_child[2], left_child[0] + right_child[2]),
                max(right_child[3], right_child[0] + left_child[3]))


def max_seg(node, l, r, query_l, query_r):
    if query_l > query_r:
        return 0, 0, 0, 0
    if l == query_l and r == query_r:
        return do[node]
    m = (l + r) // 2
    left_child = max_seg(node * 2, l, m, query_l, min(query_r, m))
    right_child = max_seg(node * 2 + 1, m + 1, r, max(query_l, m + 1), query_r)
    return max(left_child[0] + right_child[0],
               max(left_child[3] + right_child[2], left_child[1], right_child[1]),
               max(left_child[2], left_child[0] + right_child[2]),
               max(right_child[3], right_child[0] + left_child[3]))


n, q = map(int, input().split())

arr = list(map(int, input().split()))

do = [(0, 0, 0, 0)] * (n * 4)

build_tree(1, 0, n - 1)

print(str(max_seg(1, 0, n - 1, 0, n - 1)[1]) + '\n')
for _ in range(q):
    x, y = map(int, input().split())
    update(1, 0, n - 1, x, y)
    print(str(max_seg(1, 0, n - 1, 0, n - 1)[1]) + '\n')
