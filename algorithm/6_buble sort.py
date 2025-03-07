'''
백준 2750 번 수 정렬하기

버블 소트는 이중 반복문을 통해,
현재 노드와 바로 오른쪽 인접한 노드간 비교하여 위치를 바꾼다.

이중 반복분에 의해 O(n**2) 시간 복잡도를 가지지만 추가적인 공간을 활용하지않는 in place 정렬 방식이다.
'''
n = int(input())
numbers = [int(input()) for _ in range(n)]

for i in range(n):
  for j in range(n-1-i):
    if numbers[j] > numbers[j+1]:
      numbers[j], numbers[j+1] = numbers[j+1], numbers[j]

for number in numbers:
  print(number)