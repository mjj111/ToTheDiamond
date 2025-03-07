'''
백준 11004 번 K번째수 구하기

퀵정렬을 divide and conquer의 알고리즘과 비슷하다. 보통 O(NlogN)이지만, 최악의 경우 O(N**2)가 된다.

주어진 영역에서 피벗을 달고, 해당 피벗이 위치해야할 (왼쪽은 본인보다 작고 오른쪽은 본인보다 큰, 오름차순)
위치를 찾아 피벗노드를 해당 위치로 이동시킨다.

이를 상위로 계속해서 쌓아 올려, 정렬된 양상을 갖게된다.
여기서 재밌는 점은,
현재 partition으로 받은 피벗이 K 번째 위치하게 된다면 k번 째 노드는 더 이상 이동할 일이 없는 정렬완료된 상태다.
그렇기 때문에 배열에서 특정 몇 번째 값을 찾는 다면 모두 정렬후 찾기보다는 피벗을 통해 정렬하게끔 하여 최적화할 수 있다.
'''


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
