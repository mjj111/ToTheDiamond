from collections import deque
n = int(input())
numbers = list(map(int, input().split()))
answer = [0] * n

dq = deque()
for i in range(n):
  now = numbers[i]

  if not dq:
    dq.append([i,now])
    continue

  if dq[-1][1] >= now:
    dq.append([i, now])
    continue

  else:
    while dq and dq[-1][1] < now:
      index, value = dq.pop()
      answer[index] = now
    dq.append([i,now])

while dq:
  index, value = dq.pop()
  answer[index] = -1

for a in answer:
  print(a, end = ' ')