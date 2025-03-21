'''
백준 11049 번 행렬 곱셈 순서
'''
n = int(input())
matrix = [list(map(int, input().split())) for _ in range(n)]

INF = float('inf')
dp = [[INF] * n for _ in range(n)]

for i in range(n):
  dp[i][i] = 0  # 자기 자신은 연산 필요 없음

for d in range(1, n):  # 간격 d만큼 확장
  for i in range(n - d):
    j = i + d
    for k in range(i, j):
      dp[i][j] = min(dp[i][j],
                     dp[i][k] + dp[k+1][j]
                     + matrix[i][0] * matrix[k][1] * matrix[j][1])

print(dp[0][n-1])