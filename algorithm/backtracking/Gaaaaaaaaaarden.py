# Gaaaaaaaaaarden
# https://www.acmicpc.net/problem/18809

from itertools import combinations
from collections import deque

dy = [1,-1,0,0]
dx = [0,0,1,-1]
def is_in(nx,ny) : return N > ny >= 0 and M > nx >= 0
def BFS():
  visited = [[0]*M for i in range(N)]
  flower = 0

  while dq:
    y, x, ylast, xlast, time, color = dq.popleft()
    if visited[ylast][xlast] == 1: continue

    if visited[y][x]:
      if visited[y][x] == (time, -color):
        visited[y][x] = 1
        flower += 1
      continue

    visited[y][x] = (time, color)

    for i in range(4):
      ny = y + dy[i]
      nx = x + dx[i]

      if not is_in(nx,ny) : continue
      if not garden[ny][nx] : continue

      dq.append((ny, nx, y, x, time+1, color))

  return flower


N, M, G, R = map(int, input().split())
garden = [list(map(int, input().split())) for _ in range(N)]
candidates = [(i, j) for i in range(N) for j in range(M) if garden[i][j] == 2]

result = 0
for total in combinations(candidates, G + R):
  for green in combinations(total, G):
    red = [pos for pos in total if pos not in green]

    dq = deque()
    for y, x in green:
      dq.append((y,x,y,x,1,1))
    for y, x in red:
      dq.append((y,x,y,x,1,-1))

    result = max(result,BFS())

print(result)