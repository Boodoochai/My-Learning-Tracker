import sys

input = sys.stdin.readline


def solve():
    d, n = input().split()
    n = int(n)
    days = {
        "Mon": 0,
        "Tue": 1,
        "Wed": 2,
        "Thu": 3,
        "Fri": 4,
        "Sat": 5,
        "Sun": 6,
    }
    l = list(map(int, input().split()))

    mi = 999999

    for x in l:
        if x < 500:
            day_type = (days[d] - x) % 7
            c = 0
            while c < x:
                ad = 0
                if day_type == 4:
                    ad = 1
                if day_type == 3:
                    ad = 2
                c += 30 + ad
                day_type = (day_type + 2 + ad) % 7
            if c == 0:
                ad = 0
                if day_type == 4:
                    ad = 1
                if day_type == 3:
                    ad = 2
                c += 30 + ad
            last = c - x
            mi = min(last, mi)
        else:
            day_type = (days[d] - x) % 7
            if day_type == 1:
                x -= 62
            if day_type == 2:
                x -= 61
            if day_type == 3:
                x -= 32
            if day_type == 4:
                x -= 31
            x %= 91
            day_type = (days[d] - x) % 7
            c = 0
            while c < x:
                ad = 0
                if day_type == 4:
                    ad = 1
                if day_type == 3:
                    ad = 2
                c += 30 + ad
                day_type = (day_type + 2 + ad) % 7
            last = c - x
            mi = min(last, mi)

    print(mi)


def main():
    t = 1
    # t = int(input())
    for _ in range(t):
        solve()


if __name__ == '__main__':
    main()
