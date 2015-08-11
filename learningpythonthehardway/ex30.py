people = 30
cars = 40
buses = 15

if cars > people:
    print "we should take the cars."
elif cars < people:
    print "we shouldn't take the cars."
else:
    print "we can't decide."

if buses > cars:
    print "That's too many buses."
elif buses < cars:
    print "maybe we could take the buses."
else:
    print "We can't decide."

if people > buses:
    print "alright, let's just take the buses."
else:
    print "Fine. Let's stay home then."
