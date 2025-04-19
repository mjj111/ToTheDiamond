# 환승
# https://www.acmicpc.net/problem/5214
from collections import deque, defaultdict

MAX = float('inf')
N, K, M = map(int, input().split())

graph = defaultdict(list)

for i in range(N, N+M) :
  line = list(map(int, input().split()))

  for j in line :
    graph[j - 1].append((i, 1))
    graph[i].append((j - 1, 0))

visited = [MAX]*(N+M)
visited[0] = 0
q = deque([(0, 1)])

def bfs() :
  while q :
    now, dist = q.popleft()

    if now == N-1 :
      return dist

    for next, cost in graph[now] :
      n_cost = dist + cost
      if visited[next] <= n_cost : continue

      visited[next] = n_cost
      q.append((next, n_cost))
  return -1

print(bfs())
