# 벽 부수고 이동하기
# https://www.acmicpc.net/problem/2206
from collections import deque

n, m = map(int, input().split())
graph = [list(map(int, list(input().strip()))) for _ in range(n)]

# visited[x][y][0]: 벽 안 부숨
# visited[x][y][1]: 벽 부숨
visited = [[[False] * 2 for _ in range(m)] for _ in range(n)]

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

def bfs():
  queue = deque()
  queue.append((0, 0, 1, False))  # x, y, 거리, 벽 부쉈는지 여부
  visited[0][0][0] = True

  while queue:
    x, y, dist, used = queue.popleft()

    # 도착했으면 정답 반환
    if x == n - 1 and y == m - 1:
      return dist

    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      if not( 0 <= nx < n and 0 <= ny < m) : continue

      # 벽이 아닐 때
      if graph[nx][ny] == 0 and not visited[nx][ny][used]:
        visited[nx][ny][used] = True
        queue.append((nx, ny, dist + 1, used))

      # 벽일 때, 아직 안 부쉈으면
      if graph[nx][ny] == 1 and used == False and not visited[nx][ny][1]:
        visited[nx][ny][1] = True
        queue.append((nx, ny, dist + 1, 1))

  return -1

print(bfs())
