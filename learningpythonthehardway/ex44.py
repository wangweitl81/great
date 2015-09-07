class Other(object):
    def implicit(self):
        print 'OTHER implicit()'

    def altered(self):
        print "OTHER altered()"

    def override(self):
        print "OTHER override()"


class Child(object):
    def __init__(self):
        self.other = Other()

    def implicit(self):
        self.other.implicit()

    def altered(self):
        self.other.altered()

    def override(self):
        self.other.override()

son = Child()
son.implicit()
son.altered()
son.override()


def long_function_name(var_one, var_two,
                       var_three, var_four):
    pass

my_list = [
    1, 2, 3,
    4, 5, 6
]
