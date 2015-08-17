from nose.tools import *
from ex48 import lexicon
from ex48 import httptool


def test_directions():
    assert_equals(lexicon.scan("north"), [('direction', 'north')])
    result = lexicon.scan("north south east")
    assert_equals(result, [('direction', 'north'),
                           ('direction', 'south'),
                           ('direction', 'east')])


def test_httpget():
    httpt = httptool('https://code.angularjs.org/1.2.10/')
    httpt.getContent()
