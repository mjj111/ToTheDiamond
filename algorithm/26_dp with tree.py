'''
백준 2533 번 사회망 서비스(SNS)
'''
import sys
sys.setrecursionlimit(10**6)

n = int(input())
tree = [[] for _ in range(n + 1)]
for _ in range(n - 1):
  u, v = map(int, input().split())
  tree[u].append(v)
  tree[v].append(u)

dp = [[0, 1] for _ in range(n + 1)]  # [해당 노드가 우수 마을X, 우수 마을O]
visited = [False] * (n + 1)

def dfs(node):
  visited[node] = True
  for child in tree[node]:
    if not visited[child]:
      dfs(child)
      dp[node][0] += dp[child][1]
      dp[node][1] += min(dp[child])

dfs(1)
print(min(dp[1]))