inf = 10 ** 20


def build_tree(node, l, r):
    if l == r:
        do[node] = (arr[l], 1)
        return
    mid = (l + r) // 2
    build_tree(node * 2, l, mid)
    build_tree(node * 2 + 1, mid + 1, r)
    left_child = do[node * 2]
    right_child = do[node * 2 + 1]
    if left_child[0] == right_child[0]:
        do[node] = (left_child[0], left_child[1] + right_child[1])
    if left_child[0] < right_child[0]:
        do[node] = left_child
    if right_child[0] < left_child[0]:
        do[node] = right_child


def update_tree(node, l, r, update_ind, val):
    if l == r:
        do[node] = (val, 1)
        return
    mid = (l + r) // 2
    if update_ind <= mid:
        update_tree(node * 2, l, mid, update_ind, val)
    else:
        update_tree(node * 2 + 1, mid + 1, r, update_ind, val)
    left_child = do[node * 2]
    right_child = do[node * 2 + 1]
    if left_child[0] == right_child[0]:
        do[node] = (left_child[0], left_child[1] + right_child[1])
    if left_child[0] < right_child[0]:
        do[node] = left_child
    if right_child[0] < left_child[0]:
        do[node] = right_child


def get_min(node, l, r, inp_l, inp_r):
    if inp_l > inp_r:
        return inf, 1
    if l == inp_l and r == inp_r:
        return do[node]
    mid = (l + r) // 2
    left_child = get_min(node * 2, l, mid, inp_l, min(inp_r, mid))
    right_child = get_min(node * 2 + 1, mid + 1, r, max(inp_l, mid + 1), inp_r)
    if left_child[0] == right_child[0]:
        return left_child[0], left_child[1] + right_child[1]
    if left_child[0] < right_child[0]:
        return left_child
    if right_child[0] < left_child[0]:
        return right_child



n, q = map(int, input().split())

arr = list(map(int, input().split()))

do = [(0, 1)] * (n * 4)

build_tree(1, 0, n - 1)

for _ in range(q):
    t, x, y = map(int, input().split())
    if t == 1:
        update_tree(1, 0, n - 1, x, y)
    if t == 2:
        print(*get_min(1, 0, n - 1, x, y - 1))
