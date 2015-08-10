from sys import argv

script, filename = argv

txt = open(filename)

print "Here's your file %r: " % filename
print txt.read()

print "I'll also ask you to type it again:"
file_again = raw_input("> ")

text_again = open(file_again)

print text_again.read()
