# 짝 두개를 구한다면 양옆에서
# 짝 사이 값들의 합을 구한다면 끝에서
n = int(input())
numbers = list(map(int, input().split()))
numbers.sort()

answer = 0
for i in range(n):
  now = numbers[i]
  start = 0
  end = i

  is_good = False
  while -1< start < end <= i:
    s = numbers[start] + numbers[end]
    if s == now:
      is_good = True
      break

    if s < now:
      start += 1
    if s > now:
      end -= 1

  if is_good:
    answer += 1
print(answer)
