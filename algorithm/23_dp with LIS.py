'''
백준  11053번 가장 긴 증가하는 부분 수열
'''
n = int(input())
arr = list(map(int, input().split()))

LIS = [1] * n  # dp[i]: i번째 원소를 마지막으로 하는 LIS 길이

for right in range(n):
  for left in range(right):
    if arr[left] < arr[right]:  # 증가하는 경우
      LIS[right] = max(LIS[right], LIS[left] + 1)

print(max(LIS))


# import bisect
#
# n = int(input())
# arr = list(map(int, input().split()))
# LIS = []
# for num in arr:
#   idx = bisect.bisect_left(LIS, num)  # 이분 탐색을 이용한 적절한 위치 찾기
#   if idx == len(LIS):
#     LIS.append(num)  # 가장 큰 값이면 추가
#   else:
#     LIS[idx] = num  # 기존 값 업데이트
# print(len(LIS))


