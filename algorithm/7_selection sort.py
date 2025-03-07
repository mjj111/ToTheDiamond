'''
백준 1427 번 내림차순으로 자릿 수 정렬하기

선택 정렬은 버블 정렬와 같이 이중 반복문을 사용하지만,
특정 인덱스를 잡고 남은 영역에서 가장 크거나 작은 값들을 특정 인덱스로 바꿔나간다.

즉, 0부터 현재 인덱스까지는 의도한 대로 정렬한 상태를 유지 및 확장해야한다.
정렬된 영역을 키우기 위해, 정렬되지 않은 영역 가장 크거나 작은 값을 찾아(선택),
정렬되지 않은 영역의 맨 왼쪽을 정렬된 영역의 오른쪽으로 바꿔주는 양상을 가진다.

'''
numbers = list(map(int, input()))
n = len(numbers)

for i in range(n):
  max_index = i
  for j in range(i+1, n):
    if numbers[j] > numbers[max_index]:
      max_index = j

  if numbers[i] < numbers[max_index]:
    numbers[i], numbers[max_index] = numbers[max_index], numbers[i]

for num in numbers:
  print(num, end = ' ')