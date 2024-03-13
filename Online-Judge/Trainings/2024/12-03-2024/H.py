import sys

sys.stdin = open('road.in')
sys.stdout = open('road.out', 'w')
input = sys.stdin.readline


def solve():
    n = int(input())
    st = []
    otmen = [0 for i in range(10 ** 5 + 1)]
    cur_vved = [0 for i in range(10 ** 5 + 1)]

    for i in range(n):
        x = int(input())
        if x > 0:
            st.append(x)
            cur_vved[x] += 1
        if x == 0:
            if len(st) > 0:
                cur_vved[st[-1]] -= 1
                st.pop()
        if x < 0:
            if cur_vved[-x] > 0:
                otmen[-x] += 1
                cur_vved[-x] -= 1
        while len(st) > 0 and otmen[st[-1]] > 0:
            otmen[st[-1]] -= 1
            cur_vved[st[-1]] -= 1
            st.pop()
        if len(st) == 0:
            print(0)
        else:
            print(st[-1])


def main():
    t = 1
    # t = int(input())
    for _ in range(t):
        solve()


if __name__ == '__main__':
    main()
