# 쿼드 트리
# https://www.acmicpc.net/problem/1992

import sys
sys.setrecursionlimit(10**6)

def quad_tree(x, y, size):
  if is_possible(x, y, size):
    result.append(str(image[x][y]))
    return

  new_size = size // 2
  result.append('(')
  quad_tree(x, y, new_size)                     # 왼쪽 위
  quad_tree(x, y + new_size, new_size)          # 오른쪽 위
  quad_tree(x + new_size, y, new_size)          # 왼쪽 아래
  quad_tree(x + new_size, y + new_size, new_size)  # 오른쪽 아래
  result.append(')')

def is_possible(x, y, size):
  base = image[x][y]
  for i in range(x, x + size):
    for j in range(y, y + size):
      if image[i][j] != base:
        return False
  return True

# 입력
N = int(sys.stdin.readline())
image = [list(map(int, sys.stdin.readline().strip())) for _ in range(N)]

result = []
quad_tree(0, 0, N)
print(''.join(result))
