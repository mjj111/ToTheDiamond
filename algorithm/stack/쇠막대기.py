import bisect

stack = []
sticks = []
lazers = []

given_s = input()

for i, now in enumerate(given_s):
  if now == '(':
    stack.append(i)

  else: # ')'
    top = stack.pop()

    if i - top == 1: # 레이저: 바로 직전이 '('인 경우
      lazers.append(i)
    else:
      sticks.append([top, i])

answer = 0

for start, end in sticks:
  left = bisect.bisect_right(lazers, start)
  right = bisect.bisect_left(lazers, end)
  count = right - left
  answer += count + 1  # 막대는 조각 수가 레이저 수 + 1이므로

print(answer)