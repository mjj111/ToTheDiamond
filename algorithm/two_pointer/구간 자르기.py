# 구간 자르기
# https://www.acmicpc.net/problem/2283

N, K = map(int, input().split())
intervals = [list(map(int, input().split())) for _ in range(N)]

MAX = 1000001
line = [0] * (MAX + 1)

# 차이 배열로 구간 표시
for i in range(N):
  start, end = intervals[i]
  line[start] += 1
  line[end] -= 1

# 겹치는 구간 수 누적합
for i in range(1, MAX):
  line[i] += line[i - 1]

# 길이 누적합
prefix = [0] * (MAX + 1)
for i in range(1, MAX + 1):
  prefix[i] = prefix[i - 1] + line[i - 1]

left = 0
right = 1
found = False

while right <= MAX:
  total = prefix[right] - prefix[left]

  if total == K:
    print(left, right)
    found = True
    break

  elif total < K:
    right += 1

  else:
    left += 1
    if left == right:
      right += 1

if not found:
  print("0 0")
