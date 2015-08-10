print """
    There's something going on here.
    With the three double-quotes.
    We'll be able to type as much as words.
    Even 4 lines if we want, or 5, or six
"""
print "I am 6'2\" tall."  # escape double-quote inside string
print 'I am 6\'2" tall.'  # escape single-quote inside string

tabby_cat = "\tI'm tabbed in."
persian_cat = "I'm split\n on a line."
backslash_cat = "I'm \\a a \\cat."

fat_cat = """
I'll do a list:
\t* Cat food
\t* Fishies
\t* Catnip\n\t* Grass
"""
print tabby_cat
print persian_cat
print backslash_cat
print fat_cat
