import sys


def simple_func():
    if(True):
        print "hello"

simple_func()


def read_file():
    try:
        f = open('ex15_sample.txt')
        s = f.readline()
        i = int(s.strip())
        print i
    except IOError as e:
        print "I/O error({0}) : {1}".format(e.errno, e.strerror)
    except ValueError:
        print "Could not convert data into an integer"
    except:
        print "Unexpected error:", sys.exc_info()[0]
        raise

read_file()
