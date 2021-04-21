import re

def solution(new_id):
    answer = new_id
    answer = answer.lower()
    answer = re.sub('[^a-z0-9\-_.]', '', answer)
    answer = re.sub('\.+', '.', answer)
    answer = re.sub('^[.]|[.]$', '', answer)
    answer = 'a' if len(answer) == 0 else answer[:15]
    answer = re.sub('^[.]|[.]$', '', answer)
    answer = answer if len(answer) > 2 else answer + "".join([answer[-1] for i in range(3-len(answer))])
    return answer