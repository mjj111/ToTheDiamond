import sys
sys.setrecursionlimit(10**6)
INF = 16000000
input = sys.stdin.readline

N = int(input())
W = [list(map(int, input().split())) for _ in range(N)]

dp = [[-1] * (1 << N) for _ in range(N)]

def dfs(now, visit):
  if visit == (1 << N) - 1:  # 모든 노드를 방문한 경우
    if W[now][0] > 0:  # 시작점으로 돌아갈 수 있는 경우
      return W[now][0]
    return INF

  if dp[now][visit] != -1:  # 이미 계산된 경우
    return dp[now][visit]

  min_cost = INF
  for next_node in range(N):
    if visit & (1 << next_node) or W[now][next_node] == 0:
      continue
    next_visited = visit | (1 << next_node)
    cost = dfs(next_node, next_visited) + W[now][next_node]
    min_cost = min(min_cost, cost)

  dp[now][visit] = min_cost
  return min_cost

print(dfs(0, 1))
