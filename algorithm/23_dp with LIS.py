'''
백준  11053번 가장 긴 증가하는 부분 수열
'''
n = int(input())
arr = list(map(int, input().split()))

dp = [1] * n  # dp[i]: i번째 원소를 마지막으로 하는 LIS 길이

for i in range(n):
  for j in range(i):
    if arr[j] < arr[i]:  # 증가하는 경우
      dp[i] = max(dp[i], dp[j] + 1)

print(max(dp))