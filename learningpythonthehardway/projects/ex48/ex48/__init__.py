import urllib
import urllib2
import re
from HTMLParser import HTMLParser


class lexicon:
    directions = ['north', 'south', 'east']
    verbs = ['']
    stop_words = ['']
    nouns = ['']
    numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9]

    @staticmethod
    def convert_number(source):
        return int(source)

    @staticmethod
    def scan(data):
        data = data.split()
        results = []

        for l in data:
            if l in lexicon.directions:
                results.append(('direction', l))
            elif l in lexicon.verbs:
                results.append(('verb', l))
            elif l in lexicon.stop_words:
                results.append(('stop', l))
            elif l in lexicon.nouns:
                results.append(('noun', l))
            elif lexicon.convert_number(l) in lexicon.numbers:
                results.append(('number', lexicon.convert_number(l)))
            else:
                results.append(('error', l))

        return results


# create a subclass and override the handler methods
class MyHTMLParser(HTMLParser):

    def handle_starttag(self, tag, attrs):
        print "Encountered a start tag:", tag

    def handle_endtag(self, tag):
        print "Encountered an end tag :", tag

    def handle_data(self, data):
        print "Encountered some data  :", data


class ResourceFetcher(HTMLParser):

    def __init__(self, baseUrl):
        self.reg = re.compile(r"\.js$")
        self.baseUrl = baseUrl
        print dir(self)
        # super(ResourceFetcher, self).__init__()
        HTMLParser.__init__(self)
        self.filelist = []

    def handle_starttag(self, tag, attrs):
        print "Encountered a start tag:", tag

    def handle_endtag(self, tag):
        print "Encountered an end tag :", tag

    def handle_data(self, data):
        print "Data       :", data
        if(self.reg.search(data)):
            testfile = urllib.URLopener()
            testfile.retrieve(self.baseUrl + data, "./js/" + data)
            print "Now the file %s has been saved. " % data
            self.filelist.append(data)

    def get_file_list(self):
        return self.filelist


class httptool:
    def __init__(self, path):
        self.baseUrl = path
        self.downloader = ResourceFetcher(self.baseUrl)

    def getContent(self):
        try:
            response = urllib2.urlopen(self.baseUrl)
            # print 'response headers: "%s"' % response.info()
            data = response.read()
            # print data
            # now parse the html and download js scripts
            self.downloader.feed(data)
            return self.downloader.get_file_list()

        except IOError, e:
            if hasattr(e, 'code'):  # HTTPError
                print 'http error code: ', e.code
            elif hasattr(e, 'reason'):  # URLError
                print "can't connect, reason: ", e.reason
            else:
                raise
