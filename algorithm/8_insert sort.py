'''
백준 11399 번 ATM 인출 시간 계산하기

삽입 정렬은 선택 정렬과 같이 정렬된 영역을 확장해 나가는 것은 비슷하나,
정렬 영역을 오른쪽에 덧붙여 추가하는게 아닌, 정렬영역에서 본인이 찾아 삽입하게 된다.
즉 삽입시 추가적인 연산으로 밀리는 경우가 생긴다.

'''


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
