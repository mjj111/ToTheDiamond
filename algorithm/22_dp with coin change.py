'''
백준 2293 동전 1
'''
n, k = map(int, input().split())
coins = [int(input()) for _ in range(n)]

dp = [0] * (k + 1)
dp[0] = 1  # 0원을 만드는 방법은 1가지

for coin in coins:
  for i in range(coin, k + 1):
    dp[i] += dp[i - coin]  # i원을 만들 때 coin을 추가한 경우의 수 추가

print(dp[k])