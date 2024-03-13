n = int(input())

min = 9999999999999999999999999999999
min_ind = -1
for i in range(n):
    a, b = input().split()
    a = int(a)

    nums2 = 0
    nums1 = 0
    nums0 = 0
    for x in b:
        if x == '1':
            nums1 += 1
        if x == '2':
            nums2 += 1
        if x == '0':
            nums0 += 1

    if nums1 >= 1 and nums0 >= 1 and nums2 >= 2:
        if min > a:
            min = a
            min_ind = i

print(min_ind + 1)