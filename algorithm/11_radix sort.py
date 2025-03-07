'''

백준 10989 번 수 정렬하기 3

기수 정렬은 주어진 값들의 자릿수를 활용해서 정렬하는 방법이다.
일의 자리부터 가장 큰 자릿수까지 반복하며,
현재 자릿수에 대한 각 큐에 값들을 쌓는다.
이후, 현재 자릿수에 대한 정렬된 배열을 갖고,
이를 최대 자릿수 까지 반복한다.

기수 정렬에 대한 시간 복잡도는 O(KN)이다. K는 데이터자릿수, N은 숫자 수

'''
import sys

def radix_sort(arr):
  max_val = max(arr)
  exp = 1

  while max_val // exp > 0:
    counting_sort(arr, exp)
    exp *= 10

def counting_sort(arr, exp):

  count = [0] * 10  # 0~9까지 자릿수를 저장할 배열

  # 현재 자릿수를 기준으로 count 배열 채우기
  for num in arr:
    index = (num // exp) % 10
    count[index] += 1

  # 누적합을 이용해 위치 조정
  for i in range(1, 10):
    count[i] += count[i - 1]

  # 정렬된 배열을 output에 저장
  i = len(arr) - 1
  output = [0] * len(arr)
  while i >= 0:
    index = (arr[i] // exp) % 10
    output[count[index] - 1] = arr[i]
    count[index] -= 1
    i -= 1

  # 원래 배열에 복사
  for i in range(len(arr)):
    arr[i] = output[i]

n = int(sys.stdin.readline())
numbers = [int(sys.stdin.readline()) for _ in range(n)]

radix_sort(numbers)

for number in numbers:
  print(number)
