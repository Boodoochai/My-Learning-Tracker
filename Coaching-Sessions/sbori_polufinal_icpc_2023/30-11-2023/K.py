import sys

sys.stdin = open('kids.in')
sys.stdout = open('kids.out', 'w')

input = sys.stdin.readline


def draw_xor(draw_a: list[list[str]], draw_b: list[list[str]]) -> tuple[int, int, int, int, list[list[str]]]:
    x1 = -1
    y1 = -1
    x2 = -1
    y2 = -1
    ffl = 0
    for i in range(len(draw_a)):
        if ffl == 1:
            break
        for j in range(len(draw_a[0])):
            if draw_a[i][j] == '*':
                x1 = i
                y1 = j
                ffl = 1
                break

    if x1 == -1:
        return 0, 0, 0, 0, draw_b

    ffl = 0
    for i in range(len(draw_b)):
        if ffl == 1:
            break
        for j in range(len(draw_b[0])):
            if draw_b[i][j] == '*':
                x2 = i
                y2 = j
                ffl = 1
                break

    if x2 == -1:
        return 0, 0, 0, 0, draw_a

    new_x_len = max(len(draw_a) + x2, len(draw_b) + x1)
    new_y_len = max(len(draw_a[0]) + y2, (len(draw_b[0]) + y1))

    new_draw_a = [['.'] * new_y_len for i in range(new_x_len)]
    new_draw_b = [['.'] * new_y_len for i in range(new_x_len)]
    new_draw_ans = [['.'] * new_y_len for i in range(new_x_len)]

    for i in range(len(draw_a)):
        for j in range(len(draw_a[0])):
            new_draw_a[i + x2][j + y2] = draw_a[i][j]

    for i in range(len(draw_b)):
        for j in range(len(draw_b[0])):
            new_draw_b[i + x1][j + y1] = draw_b[i][j]

    for i in range(new_x_len):
        for j in range(new_y_len):
            if new_draw_a[i][j] != new_draw_b[i][j]:
                new_draw_ans[i][j] = '*'

    '''
    for i in range(new_x_len):
        print(*new_draw_ans[i], sep='')
    print()
    '''

    return x1, y1, x2, y2, new_draw_ans


'''
    while len(draw_a) < len(draw_b):
        draw_a.append(['.'] * len(draw_b[0]))

    while len(draw_b) < len(draw_a):
        draw_b.append(['.'] * len(draw_a[0]))

    for i in range(len(draw_a)):
        while len(draw_a[i]) < len(draw_b[0]):
            draw_a[i].append('.')

    for i in range(len(draw_a)):
        while len(draw_b[i]) < len(draw_a[0]):
            draw_b[i].append('.')

    for i in range(len(draw_a)):
        while len(draw_a[i]) < len(draw_b[0]):
            draw_a[i].append('.')

    draw_ans: list[list[str]] = [[] for i in range(len(draw_a))]

    # if y1 - y2 <= 0:
    if True:
        for i in range(len(draw_a)):
            for j in range(len(draw_a[0]) + y1 + y2):
                if x1 + i >= len(draw_a) or y1 - y2 + j >= len(draw_a[0]) or y1 - y2 + j < 0:
                    if x2 + i >= len(draw_b) or j >= len(draw_b[0]):
                        draw_ans[i].append('.')
                        continue
                    else:
                        draw_ans[i].append(draw_b[i + x2][j])
                        continue
                if x2 + i >= len(draw_b) or j >= len(draw_b[0]):
                    draw_ans[i].append(draw_a[x1 + i][y1 - y2 + j])
                    continue
                if draw_a[x1 + i][y1 - y2 + j] == '.' and draw_b[i + x2][j] == '.':
                    draw_ans[i].append('.')
                    continue
                if draw_a[x1 + i][y1 - y2 + j] == '*' and draw_b[i + x2][j] == '*':
                    draw_ans[i].append('.')
                    continue
                draw_ans[i].append('*')

        return x1, y1, x2, y2, draw_ans
    else:
        for i in range(len(draw_a)):
            for j in range(len(draw_a[0]) + y1 + y2):
                if x1 + i >= len(draw_a) or j >= len(draw_a[0]) or j < 0:
                    if x2 + i >= len(draw_b) or j + y2 - y1 >= len(draw_b[0]):
                        draw_ans[i].append('.')
                        continue
                    else:
                        draw_ans[i].append(draw_b[i + x2][j + y2 - y1])
                        continue
                if x2 + i >= len(draw_b) or j + y2 - y1 >= len(draw_b[0]):
                    draw_ans[i].append(draw_a[x1 + i][j])
                    continue
                if draw_a[x1 + i][j] == '.' and draw_b[i + x2][j + y2 - y1] == '.':
                    draw_ans[i].append('.')
                    continue
                if draw_a[x1 + i][j] == '*' and draw_b[i + x2][j + y2 - y1] == '*':
                    draw_ans[i].append('.')
                    continue
                draw_ans[i].append('*')

        return x1, y1, x2, y2, draw_ans
'''


def is_equal_draw(draw_a: list[list[str]], draw_b: list[list[str]]) -> tuple[int, int, int, int, bool]:
    x1 = 0
    y1 = 0
    x2 = 0
    y2 = 0
    ffl = 0
    for i in range(len(draw_a)):
        if ffl == 1:
            break
        for j in range(len(draw_a[0])):
            if draw_a[i][j] == '*':
                x1 = i
                y1 = j
                ffl = 1
                break

    ffl = 0
    for i in range(len(draw_b)):
        if ffl == 1:
            break
        for j in range(len(draw_b[0])):
            if draw_b[i][j] == '*':
                x2 = i
                y2 = j
                ffl = 1
                break

    new_x_len = max(len(draw_a) + x2, len(draw_b) + x1)
    new_y_len = max(len(draw_a[0]) + y2, (len(draw_b[0]) + y1))

    new_draw_a = [['.'] * new_y_len for i in range(new_x_len)]
    new_draw_b = [['.'] * new_y_len for i in range(new_x_len)]

    for i in range(len(draw_a)):
        for j in range(len(draw_a[0])):
            new_draw_a[i + x2][j + y2] = draw_a[i][j]

    for i in range(len(draw_b)):
        for j in range(len(draw_b[0])):
            new_draw_b[i + x1][j + y1] = draw_b[i][j]

    for i in range(new_x_len):
        for j in range(new_y_len):
            if new_draw_a[i][j] != new_draw_b[i][j]:
                return -1, -1, -1, -1, False

    return x1, y1, x2, y2, True


'''
    while len(draw_a) < len(draw_b):
        draw_a.append(['.'] * len(draw_b[0]))

    while len(draw_b) < len(draw_a):
        draw_b.append(['.'] * len(draw_a[0]))

    for i in range(len(draw_a)):
        while len(draw_a[i]) < len(draw_b[0]):
            draw_a[i].append('.')

    for i in range(len(draw_a)):
        while len(draw_b[i]) < len(draw_a[0]):
            draw_b[i].append('.')

    for i in range(len(draw_a)):
        while len(draw_a[i]) < len(draw_b[0]):
            draw_a[i].append('.')

    fl = True

    for i in range(len(draw_a)):
        for j in range(len(draw_a[0]) + y1 + y2):
            if x1 + i >= len(draw_a) or y1 - y2 + j >= len(draw_a[0]) or y1 - y2 + j < 0:
                if x2 + i >= len(draw_b) or j >= len(draw_b[0]):
                    pass
                    continue
                else:
                    if draw_b[i + x2][j] == '*':
                        fl = False
                        continue
                continue
            if x2 + i >= len(draw_b) or j >= len(draw_b[0]):
                if draw_a[i + x1][y1 - y2 + j] == '*':
                    fl = False
                continue
            if draw_a[x1 + i][y1 - y2 + j] != draw_b[i + x2][j]:
                fl = False
                continue
    return x1, y1, x2, y2, fl
'''


def main():
    n, m = map(int, input().split())

    first_draw = [list(input().replace('\n', '')) for _ in range(n)]

    n, m = map(int, input().split())

    second_draw = [list(input().replace('\n', '')) for _ in range(n)]

    n, m = map(int, input().split())

    third_draw = [list(input().replace('\n', '')) for _ in range(n)]

    x1, y1, x2, y2, draw_1 = draw_xor(first_draw, second_draw)
    x3, y3, x4, y4, fl = is_equal_draw(draw_1, third_draw)
    '''
    print(x1, y1, x2, y2)
    print(x3, y3, x4, y4)
    '''
    if fl:
        print("YES")
        print((y2 - y1) * -1, (x2 - x1) * -1)
        exit()

    x1, y1, x2, y2, draw_2 = draw_xor(third_draw, second_draw)
    x3, y3, x4, y4, fl = is_equal_draw(draw_2, first_draw)

    if fl:
        print("YES")
        # correct
        print((y3 - y4 - y1) * -1, (x3 - x4 - x1) * -1)
        # print(y4 - y3, -x2 + x4 - x3)
        exit()

    x1, y1, x2, y2, draw_3 = draw_xor(third_draw, first_draw)
    x3, y3, x4, y4, fl = is_equal_draw(draw_3, second_draw)

    if fl:
        print("YES")
        print((y3 - y4 - y1) * 1, (x3 - x4 - x1) * 1)
        # correct
        # print(y3 - y4, x2 + x3 - x4)
        exit()

    print("NO")


main()
