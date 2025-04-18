# 최솟값 찾기
# https://www.acmicpc.net/problem/11003

from collections import deque
N, L = map(int, input().split())
nums = list(map(int, input().split()))

answer = []

dq = deque()
for i, now  in enumerate(nums):
  #가장 작은 애들만 넣도록 한다.
  while dq and dq[-1][1] > now:
    dq.pop()
  dq.append([i,now])

  while dq and dq[0][0] <= i - L:
    dq.popleft()

  answer.append(dq[0][1])

print(" ".join(map(str, answer)))