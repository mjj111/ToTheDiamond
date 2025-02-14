#선택 정렬
n = int(input())
numbers = list(map(int, input().split()))

for i in range(1, n):
  insert_value = numbers[i]
  insert_point = i

  # 본인의 위치 찾기
  for j in range(i - 1, -1, -1):
    if numbers[j] < insert_value:
      insert_point = j + 1
      break
    if j == 0:
      insert_point = 0

  # 찾은 위치 한 칸씩 미루기
  for j in range(i, insert_point, -1):
    numbers[j] = numbers[j - 1]
  numbers[insert_point] = insert_value

print(numbers)

# 누적 합 계산
prefix_s = [0] * (n + 1)
for i in range(1, n + 1):
  prefix_s[i] = prefix_s[i - 1] + numbers[i - 1]

print(sum(prefix_s))
