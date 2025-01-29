import sys

def dfs(x, count):
  global answer
  if answer <= count:
    return
  if check():
    answer = count
    return

  for i in range(x, h + 1):
    for j in range(1, n):
      if map[i][j] == 0 and map[i][j + 1] == 0:
        map[i][j] = 1
        map[i][j + 1] = 2
        dfs(i, count + 1)
        map[i][j] = map[i][j + 1] = 0

def check():
  for i in range(1, n + 1):
    y = i
    for x in range(1, h + 1):
      if map[x][y] == 1:
        y += 1
      elif map[x][y] == 2:
        y -= 1
    if y != i:
      return False
  return True

if __name__ == "__main__":
  input = sys.stdin.readline

  n, m, h = map(int, input().split())

  map = [[0] * (n + 1) for _ in range(h + 1)]

  for i in range(1, m + 1):
    x, y = map(int, input().split())
    map[x][y] = 1
    map[x][y + 1] = 2

  answer = 4
  dfs(1, 0)

  print(answer if answer != 4 else -1)