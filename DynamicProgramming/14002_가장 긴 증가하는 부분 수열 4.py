n = int(input())
arr = list(map(int, input().split()))

dp = [1] * n
lis = 1

for i in range(1, n):
    for j in range(i):
        if arr[i] > arr[j]:
            dp[i] = max(dp[i], dp[j] + 1)
            lis = max(lis, dp[i])

# LIS를 추적하여 역추적
stack = []
for i in range(n - 1, -1, -1):
    if dp[i] == lis:
        stack.append(arr[i])
        lis -= 1

print(len(stack))
print(' '.join(map(str, reversed(stack))))
