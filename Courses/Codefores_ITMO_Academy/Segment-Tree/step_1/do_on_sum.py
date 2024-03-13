def build_tree(node, l, r):
    if l == r:
        do[node] = arr[l]
        return
    mid = (l + r) // 2
    build_tree(node * 2, l, mid)
    build_tree(node * 2 + 1, mid + 1, r)
    do[node] = do[node * 2] + do[node * 2 + 1]


def update_tree(ind, val, node, l, r):
    if l == r:
        do[node] = val
        return
    mid = (l + r) // 2
    if ind < mid:
        update_tree(ind, val, node * 2, l, mid)
    else:
        update_tree(ind, val, node * 2 + 1, mid + 1, r)
    do[node] = do[node * 2] + do[node * 2 + 1]


def get_sum(inp_l, inp_r, node, l, r):
    if inp_l > inp_r:
        return 0
    if l == inp_l and r == inp_r:
        return do[node]
    mid = (l + r) // 2
    left_child = get_sum(inp_l, min(mid, inp_r), node * 2, l, mid)
    right_child = get_sum(max(inp_l, mid + 1), inp_r, node * 2 + 1, mid + 1, r)
    return left_child + right_child


n, m = map(int, input().split())
arr = list(map(int, input().split()))

do = [0] * (len(arr) * 4)

build_tree(1, 0, len(arr) - 1)

for i in range(m):
    q, x, y = map(int, input().split())
    if q == 1:
        update_tree(x-1, y, 1, 0, len(arr) - 1)
    if q == 2:
        print(get_sum(x, y - 1, 1, 0, len(arr) - 1))
