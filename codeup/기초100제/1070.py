word = input()

def f(word):
    return {'12': 'winter', '1': 'winter', '2': 'winter', '3': 'spring', '4': 'spring', '5': 'spring', '6': 'summer', '7': 'summer', '8': 'summer', '9': 'fall', '10': 'fall', '11': 'fall'}.get(word, 'what?')

print(f(word));