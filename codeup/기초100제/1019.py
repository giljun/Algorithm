year, month, day = input().split('.')

print('%04d' % int(year), end='.')
print('%02d' % int(month), end='.')
print('%02d' % int(day))
