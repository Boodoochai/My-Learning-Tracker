import sys

input = sys.stdin.readline

mod1 = 10 ** 9 + 7
mod2 = 10 ** 9 + 9
osn = 100
count_step_to = 10 ** 5 * 2
step_osn1 = [1] * count_step_to
step_osn2 = [1] * count_step_to
for i in range(1, count_step_to):
    step_osn1[i] = (step_osn1[i - 1] * osn) % mod1
    step_osn2[i] = (step_osn2[i - 1] * osn) % mod2


def solve():
    a = list(map(lambda x: ord(x) - ord('a') + 1, input()))[:-1]
    ar = a.copy()[::-1]

    hashes1 = [0] * len(a)
    hashes1[0] = a[0] % mod1
    for i in range(1, len(a)):
        hashes1[i] = (hashes1[i - 1] * osn + a[i]) % mod1

    hashes2 = [0] * len(ar)
    hashes2[0] * ar[0] % mod2
    for i in range(1, len(ar)):
        hashes2[i] = (hashes2[i - 1] * osn + ar[i]) % mod2

    for i in range(len(a)):
        l = 0
        r = len(a)


def main():
    t = 1
    # t = int(input())
    for _ in range(t):
        solve()


if __name__ == '__main__':
    main()
