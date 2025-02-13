n, q = map(int, input().split())
numbers = []
for i in range(n):
  numbers.append(list(map(int, input().split())))
p_sum = [[0] * (n+1) for _ in range(n+1)]
for i in range(1, n+1):
  for j in range(1, n+1):
    p_sum[i][j] = (
        p_sum[i-1][j]
        + p_sum[i][j-1]
        - p_sum[i-1][j-1]
        + numbers[i-1][j-1]
    )

for _ in range(q):
  x1, y1, x2, y2 = map(int, input().split())
  answer = (
      p_sum[x2][y2]
      - p_sum[x1 - 1][y2]
      - p_sum[x2][y1 - 1]
      + p_sum[x1 - 1][y1 - 1]
  )
  print(answer)
