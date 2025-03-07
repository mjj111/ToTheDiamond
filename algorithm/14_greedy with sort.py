'''
백준 1744 번 회의실 배정하기

그리디는 현재에서 가장 최선의 답을 찾는 방법으로,
대부분 정렬을 통해 문제에 접근한다.

주의해야할 점은,
그리디의 특정상 최선의 선택을 위해 현재 주어진 상황에서 가장 작거나 큰 값에 접근하는 경우가 많기 때문에
한번 정렬된 값에 접근하기 보다는
계속해서 바뀐 영역에서 최선(최대 최소)의 값에 접근하는 경우가 많다.

PriorityQueue를 주로 사용하며, 파이썬에서는 heapq를 지원해준다.
파이썬의 heapq는 주어진 요소의 왼쪽부터 순차적 값에 의한 최소힙이기 때문에 이를 고려해서 노드를 관리해야한다.
'''

import sys
import heapq

input = sys.stdin.readline

pq = []  # 양수 저장 (내림차순, 최대 힙처럼 사용)
mq = []  # 음수 저장 (기본 최소 힙)
one = 0
zero = 0

n = int(input())
for _ in range(n):
  data = int(input())
  if data > 1:
    heapq.heappush(pq, -data)  # 최대 힙처럼 사용 (음수로 저장)
  elif data == 1:
    one += 1
  elif data == 0:
    zero += 1
  else:
    heapq.heappush(mq, data)  # 음수는 그대로 최소 힙

sum_value = 0

# 양수 처리 (최대 힙)
while len(pq) > 1:
  sum_value += (-heapq.heappop(pq)) * (-heapq.heappop(pq))

if pq:
  sum_value += -heapq.heappop(pq)

# 음수 처리 (최소 힙)
while len(mq) > 1:
  sum_value += heapq.heappop(mq) * heapq.heappop(mq)

if mq and zero == 0:
  sum_value += heapq.heappop(mq)

# 1의 개수 더하기
sum_value += one

print(sum_value)
