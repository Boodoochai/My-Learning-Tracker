osn = 140
mod = 10 ** 9 + 7
count_step_to = 10 ** 5
osn_step = [0] * count_step_to
osn_step[0] = 1
for i in range(1, count_step_to):
    osn_step[i] = (osn_step[i - 1] * osn) % mod


def hash(s, x, y):
    ha = s[y]
    if x != 0:
        ha = (ha - s[x - 1]) % mod
    # ha = (ha / (osn ** (len(s) - y))) % mod
    ha = (ha * osn_step[len(s) - y - 1]) % mod
    return ha


def count_pref_hash(a):
    pref_hash = [0] * len(a)
    pref_hash[0] = a[0]
    for i in range(1, len(a)):
        pref_hash[i] = (pref_hash[i - 1] + a[i] * osn_step[i]) % mod
    return pref_hash


def solve():
    a = [ord(x) for x in input()]

    pref_hash = count_pref_hash(a)

    q = int(input())
    for i in range(q):
        a, b, c, d = map(int, input().split())
        a -= 1
        b -= 1
        c -= 1
        d -= 1
        if hash(pref_hash, a, b) == hash(pref_hash, c, d):
            print('Yes')
        else:
            print('No')


def main():
    t = 1
    # t = int(input())
    for i in range(t):
        solve()


if __name__ == '__main__':
    main()
