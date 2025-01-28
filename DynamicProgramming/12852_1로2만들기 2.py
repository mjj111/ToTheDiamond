n = int(input())
sequence = []
dp = [0] * (n + 1)
trace = [0] * (n + 1)

for i in range(2, n + 1):
  dp[i] = dp[i - 1] + 1
  trace[i] = i - 1

  if i % 2 == 0 and dp[i // 2] + 1 < dp[i]:
    dp[i] = dp[i // 2] + 1
    trace[i] = i // 2

  if i % 3 == 0 and dp[i // 3] + 1 < dp[i]:
    dp[i] = dp[i // 3] + 1
    trace[i] = i // 3

while n > 0:
  sequence.append(n)
  n = trace[n]

print(dp[-1])
for s in sequence:
  print(s, end = " ")