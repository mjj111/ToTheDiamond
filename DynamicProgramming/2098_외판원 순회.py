import sys
INF = 16000000
input = sys.stdin.readline

N = int(input())
W = [list(map(int, input().split())) for _ in range(N)]

def dfs(now, visit):
  if visit == (1 << N) - 1:  # 모든 노드를 방문한 경우
    if W[now][0] > 0 :
      return W[now][0] #시작점으로 돌아갈 수 있으면 비용 반환
    return INF

  min_cost = INF
  for next_node in range(N):
    if visit & (1 << next_node) or W[now][next_node] == 0:
      continue
    next_visited = visit | (1 << next_node)
    cost = dfs(next_node, next_visited) + W[now][next_node]
    min_cost = min(min_cost, cost)

  return min_cost

print(dfs(0, 1))

