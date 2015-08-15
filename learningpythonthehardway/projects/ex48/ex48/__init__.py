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


print(lexicon.scan("north south east"))
