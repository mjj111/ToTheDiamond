N = int(input())
A = list(map(int, input().split()))
M = int(input())
arr = list(map(int, input().split()))
A.sort()

for num in arr:
  start, end = 0, N - 1
  isExist = False

  # 이분탐색 시작
  while start <= end:
    mid = (start + end) // 2
    if num == A[mid]:
      isExist = True
      print(1)
      break
    elif num > A[mid]:
      start = mid + 1
    else:
      end = mid - 1

  if not isExist:
    print(0)