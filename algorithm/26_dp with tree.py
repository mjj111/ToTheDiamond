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

# dp[i][0] 본인이 얼리어답터가 아닌 경우 최소 수
# dp[i][1] 본인이 얼리어답터일 경우 최소 수
dp = [[0, 1] for _ in range(n + 1)]
visited = [False] * (n + 1)

def dfs(node):
  visited[node] = True
  for child in tree[node]:
    if not visited[child]:
      dfs(child)
      #본인이 얼리어답터가 아니라면 자녀들은 모두 얼리어답터여야한다.
      dp[node][0] += dp[child][1]
      #본인이 얼리어답터라면 상관없이 최소값으로 자녀를 받아드린다.
      dp[node][1] += min(dp[child])

dfs(1)
print(min(dp[1]))