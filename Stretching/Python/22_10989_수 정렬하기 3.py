#기수 정렬
n = int(input())
numbers = [int(input()) for _ in range(n)]

def counting_sort(arr):
  max_val = max(arr)
  count_arr = [0] * (max_val + 1)

  for num in arr:
    count_arr[num] += 1

  for i in range(1, len(count_arr)):
    count_arr[i] += count_arr[i-1]

  output_arr = [0] * len(arr)

  i = len(arr) - 1
  while i >= 0:
    output_arr[count_arr[arr[i]] - 1] = arr[i]
    count_arr[arr[i]] -= 1
    i -= 1

  for i in range(len(arr)):
    arr[i] = output_arr[i]

counting_sort(numbers)
for number in numbers:
  print(number)