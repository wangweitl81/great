import urllib2


class httptool:
    def getContent(self, url):
        try:
            response = urllib2.urlopen(url)
            print 'response headers: "%s"' % response.info()
            data = response.read()
            print data
            return data
        except IOError, e:
            if hasattr(e, 'code'):  # HTTPError
                print 'http error code: ', e.code
            elif hasattr(e, 'reason'):  # URLError
                print "can't connect, reason: ", e.reason
            else:
                raise


