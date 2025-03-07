'''
백준 11003 번 최솟값 찾기

슬라이딩 위도우는 보통, 특정 크기의 왼도우를 오른쪽으로 슬라이딩한다.
단순히 슬라이딩 하는 경우에는 한 칸씩 조건에 맞춰서 수행하면 되지만,
슬라이딩 내부 범위안에서 최소*최대 값을 찾는 경우 queue의 활용이 필요하다.

참고로, 큐와 스택을 활용한 문제를 풀면 늘 그러하듯이 인덱스와 값을 노드로 활용한다.
'''

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