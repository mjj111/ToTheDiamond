s = input()
n = len(s)

dp = [[0] * n for _ in range(n)]
for i in range(n):
    dp[i][i] = 1

MOD = 10007

for window in range(1, n):
    for i in range(n - window):
        if s[i] != s[i + window]:
            dp[i][i + window] = (dp[i][i + window - 1] + dp[i + 1][i + window] - dp[i + 1][i + window - 1]) % MOD

        if s[i] == s[i + window]:
            dp[i][i + window] = (dp[i][i + window - 1] + dp[i + 1][i + window] + 1) % MOD

print(dp[0][n - 1])