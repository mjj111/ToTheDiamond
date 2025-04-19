# 트리의 높이와 너비
# https://www.acmicpc.net/problem/2250

import sys
sys.setrecursionlimit(10**6)

N = int(input())
tree = [[-1, -1] for _ in range(N + 1)]
is_child = [False] * (N + 1)

for _ in range(N):
  parent, left, right = map(int, input().split())
  tree[parent] = [left, right]

  if left != -1:
    is_child[left] = True
  if right != -1:
    is_child[right] = True

root = 0
for i in range(1, N+1):
  if not is_child[i]:
    root = i
    break

positions = [[] for _ in range(N + 1)]
x = 1  # x 좌표는 1부터 시작

def inorder(node, depth):
  global x
  left, right = tree[node]

  if left != -1:
    inorder(left, depth + 1)

  positions[depth].append(x)
  x += 1

  if right != -1:
    inorder(right, depth + 1)

inorder(root, 1)

# 최대 너비 계산
max_layer = 0
max_width = 0

for depth in range(1, N + 1):
  if positions[depth]:
    width = max(positions[depth]) - min(positions[depth]) + 1
    if width > max_width:
      max_width = width
      max_layer = depth

print(max_layer, max_width)