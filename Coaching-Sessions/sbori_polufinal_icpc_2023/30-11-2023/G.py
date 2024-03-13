import sys
from queue import PriorityQueue

input = sys.stdin.readline


def main():
    n = int(input())
    a, b, c = map(int, input().split())
    subs_num = list(map(int, input().split()))
    subs = [[] for i in range(n)]

    for i in range(n):
        for j in range(subs_num[i]):
            subs[j].append(list(input().split()))
            subs[j][0] = int(subs[j][0])
            subs[j][1] = int(subs[j][1])

    cur_subs = [0] * n

    q = PriorityQueue()

    done_st = 0

    while done_st < n:
        pass

main()
