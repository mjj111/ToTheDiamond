import collections

given_string = input()
counts = collections.defaultdict(int)

for s in given_string:
    counts[s] += 1

for i in range(ord('a'), ord('z') + 1):
    print(counts[chr(i)], end=' ')