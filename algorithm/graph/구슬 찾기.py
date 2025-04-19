# 구슬 찾기
# https://www.acmicpc.net/problem/2617

from collections import deque

def bfs(start, graph):
  visited = [False] * (N + 1)

  queue = deque([start])
  visited[start] = True
  count = 0

  while queue:
    current = queue.popleft()

    for next in graph[current]:
      if visited[next]: continue

      visited[next] = True
      count += 1
      queue.append(next)
  return count


N, M = map(int, input().split())

heavy = [[] for _ in range(N + 1)]
light = [[] for _ in range(N + 1)]

for _ in range(M):
  a, b = map(int, input().split())
  heavy[b].append(a)  # b보다 무거운 a
  light[a].append(b)  # a보다 가벼운 b

ans = 0
mid = (N + 1) / 2

for i in range(1, N + 1):
  if bfs(i, heavy) >= mid:
    ans += 1

  if bfs(i, light) >= mid:
    ans += 1

print(ans)
