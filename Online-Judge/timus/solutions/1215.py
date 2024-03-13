from math import sqrt


def ve(a, b):
    return a[1] * b[0] - a[0] * b[1]


def mi(a, b):
    return (a[0] - b[0], a[1] - b[1])


x1, y1, n = map(int, input().split())

l = [list(map(int, input().split())) for i in range(n)]

zn = ve(mi(l[0], (x1, y1)), mi(l[1], (x1, y1)))
k = 0
while zn == 0:
    k += 1
    zn = ve(mi(l[k], (x1, y1)), mi(l[(k+1)%n], (x1, y1)))
fl = 0
for i in range(n):
    if zn * ve(mi(l[i], (x1, y1)), mi(l[(i + 1) % n], (x1, y1))) < 0:
        fl = 1
if not fl:
    print(0)
    exit()

rast = 9999999999999999999

for i in range(n):
    ab = (l[i % n][0] - l[(i + 1) % n][0], l[i % n][1] - l[(i + 1) % n][1])
    ax = (x1 - l[(i + 1) % n][0], y1 - l[(i + 1) % n][1])
    bx = (x1 - l[(i) % n][0], y1 - l[(i) % n][1])
    ax_l = sqrt(ax[0] ** 2 + ax[1] ** 2)
    ab_l = sqrt(ab[0] ** 2 + ab[1] ** 2)
    rast = min(rast, ax_l)
    r = abs(ve(ab, ax)) / ab_l
    if ab[0] * ax[0] + ab[1] * ax[1] >= 0 and -ab[0] * bx[0] + -ab[1] * bx[1] >= 0:
        rast = min(rast, r)

print(round(rast * 2, 3))

'''
2 0 4
2 1
3 2
2 4
1 3

1 1 4
2 1
3 2
2 4
1 3

2 2 4
2 1
3 2
2 4
1 3
'''
