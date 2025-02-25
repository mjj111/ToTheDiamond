import sys
from collections import deque
input = sys.stdin.readline

N, L = map(int,input().split())
numbers = list(map(int, input().split()))

dq = deque()

for i in range(N):
  now = numbers[i]
 # [index, value]
  while dq and dq[-1][1] > now:
    dq.pop()
  dq.append([i,now])

  if dq[0][0] <= i -L:
    dq.popleft()
  print(dq[0][1])