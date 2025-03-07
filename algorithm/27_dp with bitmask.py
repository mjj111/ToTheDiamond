'''
백준 2098 번 외판원 순회
'''
n = int(input())
INF = float('inf')
cost = [list(map(int, input().split())) for _ in range(n)]
dp = [[INF] * (1 << n) for _ in range(n)]

def tsp(cur, visited):
  if visited == (1 << n) - 1:
    return cost[cur][0] if cost[cur][0] else INF
  if dp[cur][visited] != INF:
    return dp[cur][visited]

  for next in range(n):
    if not visited & (1 << next) and cost[cur][next]:
      dp[cur][visited] = min(dp[cur][visited], tsp(next, visited | (1 << next)) + cost[cur][next])

  return dp[cur][visited]

print(tsp(0, 1))