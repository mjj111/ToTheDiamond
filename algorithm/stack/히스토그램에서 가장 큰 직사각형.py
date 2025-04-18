# 히스토그램에서 가장 큰 직사각형
# https://www.acmicpc.net/problem/6549

def largest_rectangle(hist):
  stack = []
  max_area = 0
  hist.append(0)  # 끝에 0을 추가해서 모든 원소를 처리

  for i, h in enumerate(hist):
    start = i

    while stack and stack[-1][1] > h:
      index, height = stack.pop()
      width = i - index
      max_area = max(max_area, height * width)

      start = index  # 시작 위치는 직사각형이 시작된 가장 왼쪽 인덱스

    stack.append((start, h))  # 시작 인덱스를 유지

  return max_area

while True:
  arr = list(map(int, input().split()))
  if arr[0] == 0:
    break
  print(largest_rectangle(arr[1:]))
