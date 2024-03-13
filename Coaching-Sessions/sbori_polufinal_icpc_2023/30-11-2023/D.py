aminos = dict()
aminos_by_id = [None] * (10 ** 6)
id = 10 ** 5 + 4


def solve(protein: list[str], stack: list[tuple]) -> bool:
    global id
    for x in protein:
        if x == 'C':
            stack.append(stack[-1])
        elif x == 'D':
            stack.pop()
        elif x == 'L':
            a = stack.pop()
            if not a[0]:
                return False
            stack.append(aminos_by_id[a[2]])
        elif x == 'P':
            a1 = stack.pop()
            a2 = stack.pop()
            if (a1[1], a2[1]) not in aminos.keys():
                aminos[(a1[1], a2[1])] = id
                new_a = (True, aminos[(a1[1], a2[1])], a1[1], a2[1])
                aminos_by_id[id] = new_a
                id += 1
            new_a = (True, aminos[(a1[1], a2[1])], a1[1], a2[1])
            if aminos_by_id[aminos[(a1[1], a2[1])]] != new_a:
                print(1/0)
            stack.append(new_a)
        elif x == 'R':
            a = stack.pop()
            if not a[0]:
                return False
            stack.append(aminos_by_id[a[3]])
        elif x == 'S':
            a1 = stack.pop()
            a2 = stack.pop()
            stack.append(a1)
            stack.append(a2)
        elif x == 'U':
            a = stack.pop()
            if not a[0]:
                return False
            stack.append(aminos_by_id[a[3]])
            stack.append(aminos_by_id[a[2]])
    return True


def main():
    protein_1 = list(input())
    protein_2 = list(input())

    st1 = []
    st2 = []

    for i in range(10 ** 5 + 2):
        aminos_by_id[i] = (False, i)
        st1.append((False, i))
        st2.append((False, i))

    res1 = solve(protein_1, st1)
    res2 = solve(protein_2, st2)

    if (not res1) and (not res2):
        print("True")
        return

    if res1 != res2 or len(st1) != len(st2):
        print("False")
        return

    for i in range(len(st1)):
        if st1[i][1] != st2[i][1]:
            print("False")
            return

    print("True")


main()
