import sys
from collections import deque
input = sys.stdin.readline

n, start, end, d = map(int, input().split())
fees = [tuple(map(int, input().split())) for _ in range(d)]
costs = list(map(int, input().split()))

edges = []
INF = -sys.maxsize
result = [INF] * n
result[start] = costs[start]

for s, e, w in fees:
  edges.append((s, e, costs[e] - w))

# 벨만-포드 알고리즘 적용
for _ in range(n - 1):
  for s, e, w in edges:
    if result[s] != INF and result[e] < result[s] + w:
      result[e] = result[s] + w

# 사이클 여부 체크
def has_positive_cycle():
  visited = [False] * n
  for s, e, w in edges:
    if result[s] != INF and result[e] < result[s] + w:
      q = deque([e])
      visited[e] = True
      while q:
        node = q.popleft()
        if node == end:
          return True
        for ss, ee, ww in edges:
          if ss == node and not visited[ee]:
            visited[ee] = True
            q.append(ee)
  return False

if result[end] == INF:
  print("gg")
elif has_positive_cycle():
  print("Gee")
else:
  print(result[end])