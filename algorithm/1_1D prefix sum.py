'''
백준 116590번 구간 합 구하기 1
참고로, prefix_sum의 크기는 numbers의 크기보다 1 더 많아야 한다.

구간 합에 대한 1차원 빌드 공식 -> prefix_sum[i] = prefix_sum[i-1] + numbers[i]

쿼리를 동작할 때,
 1번째부터 3까지 원할 경우, (1,2,3)
prefix_sum[3] - prefix_sum[0] 을 수행해야한다.

구간 합에 대한 1차원 쿼리 공식 -> prefix_sum[end] - prefix_sum[start-1]
'''

n, q = map(int, input().split())
numbers = list(map(int, input().split()))

prefix_sum = [0] * (n+1)
for i in range(1, n+1):
  prefix_sum[i] = prefix_sum[i-1] + numbers[i-1]

for _ in range(q):
  start, end = map(int,input().split())
  print(prefix_sum[end] - prefix_sum[start-1])