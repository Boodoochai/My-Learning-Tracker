def get_sum(pref_sum, left, right):
    q = pref_sum[right]
    if left > 0:
        q -= pref_sum[left - 1]
    return q


def have_dif(left_as_me, left, right):
    le = (right - left) + 1
    if left_as_me[right] >= le - 1:
        return False
    return True


def solve():
    n = int(input())
    l = list(map(int, input().split()))

    pref_sum = [0] * n
    pref_sum[0] = l[0]
    for i in range(1, n):
        pref_sum[i] = pref_sum[i - 1] + l[i]

    left_as_me = [0] * n
    for i in range(1, n):
        if l[i] == l[i - 1]:
            left_as_me[i] = left_as_me[i - 1] + 1

    gl_ans = [-1] * n

    for i in range(n):
        ans = 10**18

        if i > 0:
            if l[i-1] > l[i]:
                ans = 1
        if i < n - 1:
            if l[i+1] > l[i]:
                ans =1

        left = 0
        right = i + 1
        while right - left > 1:
            m = (left + right) // 2
            if get_sum(pref_sum, i - m, i - 1) > l[i] and (
                    (i - 1 - (i - m) + 1) == 1 or have_dif(left_as_me, i - m, i - 1)):
                right = m
            else:
                left = m
        if right != i + 1:
            ans = min(ans, right)

        left = 0
        right = n - i
        while right - left > 1:
            m = (left + right) // 2
            if get_sum(pref_sum, i + 1, i + m) > l[i] and (
                    (i + m - (i + 1) + 1) == 1 or have_dif(left_as_me, i + 1, i + m)):
                right = m
            else:
                left = m
        if right != n - i:
            ans = min(ans, right)

        if ans == 10**18:
            ans = -1
        gl_ans[i] = ans

    print(*gl_ans)


def main():
    t = int(input())
    for _ in range(t):
        solve()


if __name__ == '__main__':
    main()
