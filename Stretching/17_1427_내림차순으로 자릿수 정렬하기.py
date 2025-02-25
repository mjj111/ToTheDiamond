#선택 정렬
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