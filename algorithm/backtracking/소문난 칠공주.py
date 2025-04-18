# 소문난 칠공주
# https://www.acmicpc.net/problem/1941
from collections import deque
from itertools import combinations

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def is_connected(selected):
  q = deque([selected[0]])
  visited = set([selected[0]])

  while q:
    x, y = q.popleft()

    for i in range(4):
      nx, ny = x + dx[i], y + dy[i]

      if (nx, ny) not in selected: continue
      if (nx, ny) in visited: continue

      visited.add((nx, ny))
      q.append((nx, ny))

  return len(visited) == 7


board = [list(input().strip()) for _ in range(5)]
answer = 0
positions = [(i, j) for i in range(5) for j in range(5)]
for comb in combinations(positions, 7):

  s_count = 0
  for x, y in comb:
    if board[x][y] == 'S': s_count += 1

  if s_count >= 4 and is_connected(comb):
    answer += 1

print(answer)