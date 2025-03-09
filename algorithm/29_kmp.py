'''
백준 1786 찾기

KMP 알고리즘은 문자열에서 특정 문자열이 존재하는지 파악하는데 사용된다.
동작 원리는 접두사와 접미사가 같은 최대 길이를 저장한 테이블을 활용하여,
일치하지 않는 경우에 불필요한 비교를 최소화한다.

테이블은 패턴의 길이만큼 생성한다.
left를 0, right를 1부터 패턴의 길이까지 움직이도록 한다. (투 포인터와 유사하지만 기록하는 과정이 추가됨)

현재 처음 동작이 아니며, (left > 0) left와 right에 해당하는 값이 다르다면
left 위치를 최대한 재사용할 수 있는 위치(이전에 일치했던 접두사 길이)로 조정해야 한다.
while left > 0 and pattern[left] != pattern[right]:
    left = table[left - 1]

그리고 만약 접두사가 접미사와 일치하다면 현재 left의 위치를 1 증가시키고 테이블을 갱신한다.

'''

def KMP_table(pattern):
  pattern_length = len(pattern)
  table = [0] * pattern_length

  left = 0
  for right in range(1, pattern_length):
    while left > 0 and pattern[left] != pattern[right]:
      left = table[left - 1]

    if pattern[left] == pattern[right]:
      left += 1
      table[right] = left

  return table

word = input().strip()
pattern = input().strip()

table = KMP_table(pattern)
result = []

pidx = 0
for widx in range(len(word)):
  while pidx > 0 and pattern[pidx] != word[widx]:
    pidx = table[pidx - 1]

  if pattern[pidx] == word[widx]:
    if pidx == len(pattern) - 1:
      result.append(widx - len(pattern) + 2)
      pidx = table[pidx]
    else:
      pidx += 1

print(len(result))
print(*result)