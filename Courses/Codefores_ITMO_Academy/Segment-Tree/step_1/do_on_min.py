inf = 10 ** 20


def build_tree(node, l, r):
    if l == r:
        do[node] = arr[l]
        return
    mid = (l + r) // 2
    build_tree(node * 2, l, mid)
    build_tree(node * 2 + 1, mid + 1, r)
    do[node] = min(do[node * 2], do[node * 2 + 1])


def update_tree(node, l, r, update_ind, val):
    if l == r:
        do[node] = val
        return
    mid = (l + r) // 2
    if update_ind <= mid:
        update_tree(node * 2, l, mid, update_ind, val)
    else:
        update_tree(node * 2 + 1, mid + 1, r, update_ind, val)
    do[node] = min(do[node * 2], do[node * 2 + 1])


def get_min(node, l, r, inp_l, inp_r):
    if inp_l > inp_r:
        return inf
    if l == inp_l and r == inp_r:
        return do[node]
    mid = (l + r) // 2
    left_child = get_min(node * 2, l, mid, inp_l, min(inp_r, mid))
    right_child = get_min(node * 2 + 1, mid + 1, r, max(inp_l, mid + 1), inp_r)
    return min(left_child, right_child)


n, q = map(int, input().split())

arr = list(map(int, input().split()))

do = [0] * (n * 4)

build_tree(1, 0, n - 1)

for _ in range(q):
    t, x, y = map(int, input().split())
    if t == 1:
        update_tree(1, 0, n - 1, x, y)
    if t == 2:
        print(get_min(1, 0, n - 1, x, y - 1))
