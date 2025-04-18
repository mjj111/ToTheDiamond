# 나이트 이동
# https://www.acmicpc.net/problem/7562
from collections import deque

test_case = int(input())

def bfs() :
  dx = [-1, 1, 2, 2, 1, -1, -2, -2]
  dy = [2, 2, 1, -1, -2, -2, -1, 1]

  q = deque()
  q.append((s_x, s_y))
  graph[s_x][s_y] = 1

  while q :
    x, y = q.popleft()

    if x == e_x and y == e_y :
      return graph[x][y] - 1

    for i in range(8) :
      nx = x + dx[i]
      ny = y + dy[i]

      if not (0 <= nx < size and 0 <= ny < size) : continue
      if not graph[nx][ny] == 0 : continue

      graph[nx][ny] = graph[x][y] + 1
      q.append((nx,ny))

for _ in range(test_case):
  size = int(input())
  visited = [[0] * size for _ in range(size)]
  graph =[[0] * size for _ in range(size)]

  s_x, s_y = map(int,input().split())
  e_x, e_y = map(int, input().split())
  answer = bfs()
  print(answer)
