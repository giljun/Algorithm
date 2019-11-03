year, month, day = input().split('.')

print("%02d" % int(day), end='-')
print("%02d" % int(month), end='-')
print("%d" % int(year))