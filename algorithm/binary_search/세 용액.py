# 세 용액
# https://www.acmicpc.net/problem/2473

N = int(input())
arr = list(map(int, input().split()))
arr.sort()

min_abs = float('inf')

def find() :
  global min_abs
  result = (0, 0, 0)
  for i in range(N - 2):
    left = i + 1
    right = N - 1

    while left < right:
      total = arr[i] + arr[left] + arr[right]

      if abs(total) < min_abs:
        min_abs = abs(total)
        result = (arr[i], arr[left], arr[right])

      if total == 0:
        # 0이면 더 이상 탐색할 필요 없음
        return [arr[i], arr[left], arr[right]]

      elif total < 0:
        left += 1
      else:
        right -= 1
  return result

print(" ".join(map(str,find())))
