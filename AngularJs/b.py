#import urllib
#import json
#import os

#json.loads('[]')

#response = urllib.urlopen('http://www.sohu.com')
#line = response.readline()
#print(response)


def greet(name):
    print 'Hello', name


greet('Jack')
greet('Jill')
greet('Bob')

words = ['cat', 'window', 'defenestrate']
for w in words:
    print w, len(w)

for w in words[:]:
    if len(w) > 6:
        words.insert(0, w)

print words

for i in range(5):
    print i

for n in range(2, 10):
    for x in range(2, n):
        if n % x == 0:
            print n, 'equals', x, '*', n//x
            break
    else:
        print n, 'is a prime number'

#while True:
#    pass


def fib(n):
    result = []
    a, b = 0, 1
    while a < n:
        print a, ' '
        a, b = b, a+b
        result.append(a)
    #print()
    return result

result = fib(2000)
print(result)
