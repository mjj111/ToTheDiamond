# 열쇠
# https://www.acmicpc.net/problem/9328
from collections import deque

dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1]

def is_door(c): return 'A' <= c <= 'Z'
def is_key(c) : return 'a' <= c <= 'z'
def is_doc(c) : return c == "$"

def bfs(visited):
  global ans
  queue = deque([[0, 0]])
  visited[0][0] = True

  while queue:
    x, y = queue.popleft()

    for i in range(4):
      nx = x + dr[i]
      ny = y + dc[i]

      if ny < 0 or ny >= w + 2 or nx < 0 or nx >= h + 2 or miro[nx][ny] == '*' or visited[nx][ny]:
        continue

      next = miro[nx][ny]

      if is_door(next) and chr(ord(next) + 32) not in key : continue

      if is_key(next) and  next not in key :
          key[next] = True
          visited = [[False] * (w + 2) for _ in range(h + 2)]  # 방문체크 초기화

      if is_doc(next) and (nx, ny) not in visited_doc:  # 비밀문서이고 아직방문하지 않았다면
        ans += 1  # 찾은 개수 1개 증가
        visited_doc.append((nx, ny))  # 해당 위치는 더이상 방문하면 안되기 때문에 저장

      visited[nx][ny] = True  # 방문처리
      queue.append([nx, ny])  # 다음 위치를 큐에 삽입


T = int(input())

for _ in range(1, T + 1):
  h, w = map(int, input().split())

  miro = ['.' + input() + '.' for _ in range(h)]
  miro = ['.' * (w + 2)] + miro + ['.' * (w + 2)]
  visited = [[False] * (w + 2) for _ in range(h + 2)]
  key = {}
  visited_doc = []

  for i in input():
    if i.isalpha():
      key[i] = True

  ans = 0
  bfs(visited)
  print(ans)