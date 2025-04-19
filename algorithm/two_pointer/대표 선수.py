# 대표 선수
# https://www.acmicpc.net/problem/2461

N, M = map(int, input().split())

students = []
for class_id in range(N):
  abilities = list(map(int, input().split()))
  for ability in abilities:
    students.append((ability, class_id))

students.sort()

count = [0] * N
total = 0  # 현재 포함된 반의 개수
min_diff = float('inf')

left = 0
for right in range(len(students)):
  ability, class_id = students[right]
  count[class_id] += 1
  if count[class_id] == 1:
    total += 1

  # 모든 반이 포함되었을 때, 왼쪽을 줄임
  while total == N:
    curr_diff = students[right][0] - students[left][0]
    min_diff = min(min_diff, curr_diff)

    count[students[left][1]] -= 1
    if count[students[left][1]] == 0:
      total -= 1
    left += 1

print(min_diff)
