def lcs_with_traceback(X: str, Y: str) -> str:
  m, n = len(X), len(Y)
  dp = [[0] * (n + 1) for _ in range(m + 1)]

  for i in range(1, m + 1):
    for j in range(1, n + 1):
      if X[i - 1] == Y[j - 1]:
        dp[i][j] = dp[i - 1][j - 1] + 1
      else:
        dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])

  i, j = m, n
  lcs_str = []

  while i > 0 and j > 0:
    if X[i - 1] == Y[j - 1]:
      lcs_str.append(X[i - 1])
      i -= 1
      j -= 1
    elif dp[i - 1][j] >= dp[i][j - 1]:
      i -= 1
    else:
      j -= 1

  return ''.join(reversed(lcs_str))

X = input()
Y = input()
print(lcs_with_traceback(X, Y))