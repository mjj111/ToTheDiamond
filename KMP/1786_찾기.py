def KMP_table(pattern):
    pattern_length = len(pattern)
    table = [0] * pattern_length

    left = 0
    for right in range(1, pattern_length):
        while left > 0 and pattern[left] != pattern[right]:
            left = table[left-1]

        if pattern[left] == pattern[right]:
            left += 1
            table[right] = left
    return table

word = input()
pattern = input()

table = KMP_table(pattern)
result = []

pidx = 0
for widx in range(len(word)):
    while pidx > 0 and pattern[pidx] != word[widx]:
        pidx = table[pidx -1]

    if pattern[pidx] == word[widx]:
        if pidx == len(pattern)-1:
            result.append(widx - len(pattern) + 2)
            pidx = table[pidx]
        else :
            pidx += 1

print(len(result))
for r in result:
    print(r, end = ' ')