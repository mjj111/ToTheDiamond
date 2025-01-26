T, W = map(int, input().split())
trees = []
for _ in range(T):
  trees.append(int(input()) - 1)

# dp[t][w][p] = 자두 개수
dp = [[[0] * 2 for _ in range(W + 1)] for _ in range(T)]

if trees[0] == 0:
  dp[0][0][0] = 1
else:
  dp[0][1][1] = 1

for t in range(1, T):
  for w in range(W + 1):
    dp[t][w][0] = max(dp[t][w][0], dp[t - 1][w][0])
    dp[t][w][1] = max(dp[t][w][1], dp[t - 1][w][1])

    if w > 0:
      dp[t][w][0] = max(dp[t][w][0], dp[t - 1][w - 1][1])
      dp[t][w][1] = max(dp[t][w][1], dp[t - 1][w - 1][0])

    if trees[t] == 0:
      dp[t][w][0] += 1

    else:
      dp[t][w][1] += 1

max_value = float('-inf')
for w in range(W+1):
  max_value = max(max_value, max(dp[T-1][w][0], dp[T-1][w][1]))

print(max_value)
