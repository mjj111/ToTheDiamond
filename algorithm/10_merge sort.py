'''
백준 2751 번 수 정렬하기 2

병합 정렬은 Divide And Conquer를 사용하여
재귀를 통해 base case까지 최대한 영역을 분할한 뒤,
분할 값들을 정렬하여 반환함으로 최상에서는 모두 정렬된 배열을 얻게된다.

피벗이나 다른 값들을 사용하는게 아닌 분리 및 병합으로 O(NlogN)의 시간 복잡도를 가진다.

'''
def merge_sort(arr):
  if len(arr) <= 1:
    return arr

  mid = len(arr) // 2
  left = merge_sort(arr[:mid])
  right = merge_sort(arr[mid:])

  return merge(left, right)

def merge(left, right):
  result = []
  i = j = 0

  while i < len(left) and j < len(right):
    if left[i] < right[j]:
      result.append(left[i])
      i += 1
    else:
      result.append(right[j])
      j += 1

  result.extend(left[i:])
  result.extend(right[j:])
  return result

n = int(input())
numbers = [int(input()) for _ in range(n)]

sorted_numbers = merge_sort(numbers)

print(*sorted_numbers)