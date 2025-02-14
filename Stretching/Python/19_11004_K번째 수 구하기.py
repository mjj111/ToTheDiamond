#퀵 정렬
#퀵 정렬은 전체 정렬이 아니라, K번째 원소만 찾을 때 매우 효율적.
#partition에서 pivot 이 나오면 해당 자리는 정렬된 자리다.(좌우는 정렬되지 않음)
def quick_sort(numbers, start, end, k):
  if start < end:
    pivot = partition(numbers, start, end)
    if pivot == k:
      return
    elif k < pivot:
      quick_sort(numbers, start, pivot - 1, k)
    else:
      quick_sort(numbers, pivot + 1, end, k)

def partition(numbers, start, end):
  if start + 1 == end:
    if numbers[start] > numbers[end]:
      numbers[start], numbers[end] = numbers[end], numbers[start]
    return start

  mid = (start + end) // 2
  numbers[start], numbers[mid] = numbers[mid], numbers[start]
  pivot = numbers[start]
  i = start + 1
  j = end

  while i <= j:
    while j >= start + 1 and pivot < numbers[j]:
      j -= 1
    while i <= end and pivot > numbers[i]:
      i += 1

    if i <= j:
      numbers[i], numbers[j] = numbers[j], numbers[i]
      i += 1
      j -= 1

  numbers[start], numbers[j] = numbers[j], numbers[start]
  return j

def main():
  n, k = map(int, input().split())
  numbers = list(map(int, input().split()))

  quick_sort(numbers, 0, n - 1, k - 1)

  print(numbers[k - 1])

main()
