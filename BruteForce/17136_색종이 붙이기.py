import sys

def dfs(x, y, cnt):
  global ans
  if x >= 9 and y > 9:
    ans = min(ans, cnt)
    return

  if ans <= cnt:
    return

  if y > 9:
    dfs(x + 1, 0, cnt)
    return

  if board[x][y] == 1:
    for size in range(5, 0, -1):
      if paper[size] > 0 and can_attach(x, y, size):
        attach(x, y, size, 0)
        paper[size] -= 1
        dfs(x, y + 1, cnt + 1)
        attach(x, y, size, 1)
        paper[size] += 1
  else:
    dfs(x, y + 1, cnt)

def can_attach(x, y, size):
  if x + size > 10 or y + size > 10:
    return False
  for i in range(x, x + size):
    for j in range(y, y + size):
      if board[i][j] != 1:
        return False
  return True

def attach(x, y, size, state):
  for i in range(x, x + size):
    for j in range(y, y + size):
      board[i][j] = state

if __name__ == "__main__":
  input = sys.stdin.readline
  board = [list(map(int, input().split())) for i in range(10)]
  paper = [0, 5, 5, 5, 5, 5]
  ans = float('inf')

  dfs(0, 0, 0)

  print(-1 if ans == float('inf') else ans)