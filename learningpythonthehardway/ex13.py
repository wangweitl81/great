from sys import argv

script, first, second, third = argv

print "The script is called: ", script
print "your first variable is:", first
print "your second variable is:", second
print "your third variable is:", third

more_input = raw_input("please input your nationality:")
print "your nation is %s." % more_input
