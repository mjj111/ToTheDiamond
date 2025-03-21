'''
백준 2098 번 외판원 순회
'''
import sys
sys.setrecursionlimit(10**6)

n = int(input())
cost = [list(map(int, input().split())) for _ in range(n)]

INF = 16000000
dp = [[-1] * (1 << n) for _ in range(n)]

def tsp(cur, visited):
  if visited == (1 << n) - 1:
    return cost[cur][0] if cost[cur][0] > 0 else INF

  if dp[cur][visited] != -1:
    return dp[cur][visited]

  min_cost = INF
  for next in range(n):
    if visited & (1 << next) or cost[cur][next] == 0:
      continue

    next_visited = visited | (1 << next)
    cost_to_next = tsp(next, next_visited) + cost[cur][next]
    min_cost = min(min_cost, cost_to_next)

  dp[cur][visited] = min_cost
  return min_cost

print(tsp(0, 1))
