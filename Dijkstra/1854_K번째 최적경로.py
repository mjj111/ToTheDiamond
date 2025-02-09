import sys
import heapq

input = sys.stdin.readline
INF = int(1e12)

N, M, K = map(int, input().split())

q = []

distance = [[] for _ in range(N+1)]
graph = [[] for _ in range(N+1)]

for _ in range(M):
  a, b, c = map(int, input().split())
  graph[a].append((c, b))

heapq.heappush(distance[1], 0)  # 비용
heapq.heappush(q, (0, 1))       # 비용, 장소

while q:
  dist, now = heapq.heappop(q)

  for i in graph[now]:
    cost = dist + i[0]
    if len(distance[i[1]]) < K:
      heapq.heappush(distance[i[1]], -cost)
      heapq.heappush(q, (cost, i[1]))
    elif cost < -distance[i[1]][0]:
      heapq.heappop(distance[i[1]])
      heapq.heappush(distance[i[1]], -cost)
      heapq.heappush(q, (cost, i[1]))

for i in range(1, N+1):
  if len(distance[i]) == K:
    print(-distance[i][0])
  else:
    print(-1)