inf = 10 ** 20


def build_tree(node, l, r):
    if l == r:
        do[node] = arr[l]
        return
    mid = (l + r) // 2
    build_tree(node * 2, l, mid)
    build_tree(node * 2 + 1, mid + 1, r)
    do[node] = max(do[node * 2], do[node * 2 + 1])


def update_tree(node, l, r, update_ind, val):
    if l == r:
        do[node] = val
        return
    mid = (l + r) // 2
    if update_ind <= mid:
        update_tree(node * 2, l, mid, update_ind, val)
    else:
        update_tree(node * 2 + 1, mid + 1, r, update_ind, val)
    do[node] = max(do[node * 2], do[node * 2 + 1])


def get_first_above(node, l, r, inp_l, x):
    if do[node] < x:
        return -1
    if l == r:
        return l
    m = (l + r) // 2
    if do[node * 2] >= x and m >= inp_l:
        ans = get_first_above(node * 2, l, m, inp_l, x)
        if ans == -1:
            return get_first_above(node * 2 + 1, m + 1, r, inp_l, x)
        return ans
    return get_first_above(node * 2 + 1, m + 1, r, inp_l, x)


n, q = map(int, input().split())

arr = list(map(int, input().split()))

do = [0] * (n * 4)

build_tree(1, 0, n - 1)

for _ in range(q):
    que = list(map(int, input().split()))
    if que[0] == 1:
        update_tree(1, 0, n - 1, que[1], que[2])
    if que[0] == 2:
        print(get_first_above(1, 0, n - 1, que[2], que[1]))
