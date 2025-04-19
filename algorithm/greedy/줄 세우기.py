N = int(input())
nums = list(map(int, input().split()))
position = dict()

for i, v in enumerate(nums):
  position[v] = i

longest = 1
cnt = 1
for i in range(1, N):
  #오름차순이라면
  if position[i] < position[i + 1]:
    cnt += 1
  else:
    longest = max(longest, cnt)
    cnt = 1
longest = max(longest, cnt)

print(N - longest if N != 1 else 0)