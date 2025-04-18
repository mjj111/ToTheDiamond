# 오아시스 재결합
# https://www.acmicpc.net/problem/3015

n = int(input())
stack = []
answer = 0

for _ in range(n):
  height = int(input())
  same = 1

  while stack and stack[-1][0] <= height:
    h, c = stack.pop()
    answer += c

    if h == height:
      same += c

  if stack:
    answer += 1

  stack.append((height, same))

print(answer)