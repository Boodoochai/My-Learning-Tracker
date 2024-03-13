def do_pref_xor(l):
    new_l = [0] * len(l)
    new_l[0] = l[0]
    for i in range(1, len(l)):
        new_l[i] = new_l[i - 1] ^ l[i]

    return new_l


def main():
    l = [1, 3, 1, 5, 0, 6]

    print(l)
    for i in range(17):
        l = do_pref_xor(l)
        print(l)
        print(*[str(bin(l[i]))[2:].rjust(8, '0') for i in range(len(l))])


main()
