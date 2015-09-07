from nose.tools import *
import unittest
from ex48 import lexicon
from ex48 import httptool


class SimpleUnitTest(unittest.TestCase):
    def test_directions(self):
        self.assertEqual(lexicon.scan("north"),
                         [('direction', 'north')], 'direction not correct!')

    def test_httpget(self):
        httpt = httptool('https://code.angularjs.org/1.2.10/')
        file_list = httpt.getContent()
        self.assertIsNone(file_list, 'downloaded list should not be empty')
        self.assertGreater(file_list.size(), 0, 'size should be great than 0')


if __name__ == '__main__':
    unittest.main()
