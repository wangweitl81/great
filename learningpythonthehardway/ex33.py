def iterate_and_print(vari, numbers):
    i = vari
    print "At the top i is %d" % i
    numbers.append(i)

    i += 1
    print "Numbers now:", numbers
    print "At the bottom i is %d" % i
    return i


def print_list(number):
    i = 0
    numbers = []
    while i < number:
        i = iterate_and_print(i, numbers)

    print "The numbers"

    for num in numbers:
        print num


def print_list_forloop(number):
    i = 0
    numbers = []
    for i in range(0, number):
        iterate_and_print(i, numbers)

    print "The numbers"

    for num in numbers:
        print num


#print_list(6)
print_list_forloop(6)
