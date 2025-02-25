n = int(input())
numbers = list(map(int, input().split()))
max_value = max(numbers)
for i in range(n):
  numbers[i] = numbers[i] / max_value * 100
print(sum(numbers)/n)