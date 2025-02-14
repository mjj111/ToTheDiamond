n = int(input())
numbers = list(int(input()) for _ in range(n))
for i in range(n):
  numbers[i] = [numbers[i], i]
numbers.sort()

max_swap = 0
for i in range(n):
  max_swap = max( numbers[i][1] - i, max_swap)

print(max_swap + 1)
