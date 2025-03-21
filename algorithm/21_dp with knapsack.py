'''
백준 12865 평범한 배낭

'''
n, k = map(int, input().split())
items = [list(map(int, input().split())) for _ in range(n)]

# dp[w]: 무게 w에서 얻을 수 있는 최대 가치
dp = [0] * (k + 1)

for weight, value in items:
  for i in range(k, weight - 1, -1):  # 뒤에서부터 탐색 (0/1 배낭)
    dp[i] = max(dp[i], dp[i - weight] + value)

print(dp[k])