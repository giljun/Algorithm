word = input()

def f(word):
    return {'A': 'best!!!', 'B': 'good!!', 'C': 'run!', 'D': 'slowly~'}.get(word, 'what?')

print(f(word));