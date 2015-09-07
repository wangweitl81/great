import urllib2

try:
    response = urllib2.urlopen('https://code.angularjs.org/1.2.10/')
    print 'response headers: "%s"' % response.info()
    data = response.read()
    print data
except IOError, e:
    if hasattr(e, 'code'):  # HTTPError
        print 'http error code: ', e.code
    elif hasattr(e, 'reason'):  # URLError
        print "can't connect, reason: ", e.reason
    else:
        raise
