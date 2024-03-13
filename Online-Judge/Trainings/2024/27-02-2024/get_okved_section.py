def get_okved_section(okved_class: int) -> str:
    """Returns okved section corresponding to okved class.

    arguments:
    okved_class : int -- okved class is number between 1 and 99

    returns:
    okved chapter : str -- okved chapter is string from one english letter in upper case

    raise:
    ValueError('That okved class do not exist') -- if okved class do not exist
    """
    okved_class_to_section = {'A': (1, 3), 'B': (5, 9), 'C': (10, 33), 'D': (35, 35), 'E': (36, 39), 'F': (41, 43),
                              'G': (45, 47), 'H': (49, 53), 'I': (55, 56), 'J': (58, 63), 'K': (64, 66), 'L': (68, 68),
                              'M': (69, 75), 'N': (77, 82), 'O': (84, 84), 'P': (85, 85), 'Q': (86, 88), 'R': (90, 93),
                              'S': (94, 96), 'T': (97, 98), 'U': (99, 99)}

    for cur_okved_chapter in okved_class_to_section.keys():
        if okved_class_to_section[cur_okved_chapter][0] <= okved_class <= okved_class_to_section[cur_okved_chapter][1]:
            return cur_okved_chapter

    raise ValueError('That okved class do not exist')


def add_okved_

def test_okved():
    for i in range(1, 100):
        try:
            print(i, get_okved_section(i))
        except ValueError:
            print(i, 'ValueError')
