from nose.tools import *
from ex48 import lexicon


def test_directions():
    assert_equals(lexicon.scan("north"), [('direction', 'north')])
    result = lexicon.scan("north south east")
    assert_equals(result, [('direction', 'north'),
                           ('direction', 'south'),
                           ('direction', 'east')])
