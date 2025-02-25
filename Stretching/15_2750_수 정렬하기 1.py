# 버블정렬
n = int(input())
numbers = [int(input()) for _ in range(n)]

for i in range(n):
  for j in range(n-1-i):
    if numbers[j] > numbers[j+1]:
      numbers[j], numbers[j+1] = numbers[j+1], numbers[j]

for number in numbers:
  print(number)