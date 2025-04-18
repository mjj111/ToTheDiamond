# 숨박꼭질 3
# https://www.acmicpc.net/problem/13549

from heapq import heappush, heappop

start, end = map(int, input().split())
visited = [False] * 100001

def is_in(i) : return 0 <= i < 100001
# 시간, 현재 위치
pq = []
heappush(pq, (0, start))

while pq:
  t, p = heappop(pq)

  if visited[p]:
    continue
  visited[p] = True

  if p == end:
    print(t)
    break

  # 순간이동
  if is_in(p * 2)  and not visited[p * 2]:
    heappush(pq, (t, p * 2))

  # +1
  if is_in(p + 1) and not visited[p + 1]:
    heappush(pq, (t + 1, p + 1))

  # -1
  if is_in(p - 1) and not visited[p - 1]:
    heappush(pq, (t + 1, p - 1))