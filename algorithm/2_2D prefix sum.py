'''
백준 116600번 구간 합 구하기 2
참고로, prefix_sum의 크기는 numbers의 크기보다 1 더 많은 이차원 배열이어야 한다.

구간 합에 대한 2차원 빌드 공식
-> prefix_sum[i][j] = prefix_sum[i-1][j] predix_sum[i][j-1] + numbers[i][j]

쿼리를 동작할 때,
x1, y1  | x2, y2 사이 구간의 합을 구한다면
-> prefix_sum[x2][y2]
- prefix_sum[x1-1][y2]
- prefix_sum[x2][y1-1]
+ prefix_sum[x1-1][y1-1]
을 수행해야한다.
'''

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
