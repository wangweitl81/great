class MyStuff(object):
    """docstring for MyStuff"""
    def __init__(self, weapon):
        self.weapon = weapon

    def output(self):
        print self.weapon


class ChildStuff(MyStuff):
    """docstring for ChildStuff"""
    def __init__(self, weapon, rifle):
        super(ChildStuff, self).__init__(weapon)
        self.rifle = rifle

    def output(self):
        print self.weapon, self.rifle


class Song(object):
    """docstring for Song"""
    def __init__(self, lyrics):
        self.lyrics = lyrics

    def sing_me_a_song(self):
        for line in self.lyrics:
            print line

happy_bday = Song(["Happy birthday to you",
                   "I don't want to get sued",
                   "So I'll stop right there"])

bulls_on_parade = Song(["They rally around the family",
                        "With pockets full of shells"])

happy_bday.sing_me_a_song()
bulls_on_parade.sing_me_a_song()

stuff = MyStuff("pistol")
stuff.output()

rifle = ChildStuff("rifle", "M1")
rifle.output()
