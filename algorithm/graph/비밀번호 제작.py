# 비밀번호 제작
# https://www.acmicpc.net/problem/20304
from collections import deque

n = int(input())
m = int(input())
before_password = list(map(int, input().split()))

# safety[x] = x의 안전도
# 최대 비트 수 + 1로 초기화
safety = [21 for _ in range(n+1)]
dq = deque()

for i in before_password:
  safety[i]=0
  dq.append(i)

ans=0

while dq:
  cur = dq.popleft()
  next_safety = safety[cur] + 1

  for i in range(20):
    x = (1<<i) ^ cur

    if x <= n and  safety[x] > next_safety :
      safety[x] = next_safety
      ans = max(safety[x], ans)

      dq.append(x)

print(ans)